package au.com.jcloud.lxd;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import au.com.jcloud.lxd.bean.LxdServerCredential;
import au.com.jcloud.lxd.model.Container;
import au.com.jcloud.lxd.model.Image;
import au.com.jcloud.lxd.model.Operation;
import au.com.jcloud.lxd.service.ILinuxCliService;
import au.com.jcloud.lxd.service.ILxdApiService;
import au.com.jcloud.lxd.service.ILxdService;
import au.com.jcloud.lxd.service.impl.LinuxCliServiceImpl;
import au.com.jcloud.lxd.service.impl.LxdApiServiceImpl;
import au.com.jcloud.lxd.service.impl.LxdServiceImpl;

/**
 * Created by david on 16/07/16.
 */
public class App {

	private static final Logger LOG = Logger.getLogger(App.class);

	public static void main(String[] args) {
		LOG.info("LXC START. args=" + args.length);
		System.out.println(args[0]);
		try {
			if (args.length == 0) {
				System.out.println("Usage: jlxd [host[:port]] <s|c|i|o> [name] [start|stop|create|delete|snaps|file]");
				System.out.println("");
				System.out.println("   s = server info");
				System.out.println("   c = list containers");
				System.out.println("   i = list images");
				System.out.println("   o = list operations");
				System.out.println("   name = a specific instance of one of the above");
				System.out.println("   start|stop|create|delete|snaps|file = only for containers");
				System.exit(1);
			}
			//ILxdService service = new LxdServiceCliImpl();
			ILxdService service = new LxdServiceImpl();
			ILxdApiService lxdApiService = new LxdApiServiceImpl();
			ILinuxCliService linuxCliService = new LinuxCliServiceImpl();
			lxdApiService.setLinuxCliService(linuxCliService);
			service.setLxdApiService(lxdApiService);
			String remoteHostAndPort = null;
			for (int i = 0; i < args.length; i++) {
				if (args[i].equals("s")) {
					LOG.info("");
					LOG.info(service.loadServerInfo());
				}
				else if (args[i].equals("c")) {
					LOG.info("");
					if (args.length - 1 == i || args[i + 1].equals("o") || args[i + 1].equals("i") || args[i + 1].equals("s")) {
						Collection<Container> containers = service.loadContainerMap().values();
						LOG.info("containers=" + containers.size());
						for (Container container : containers) {
							LOG.info("container=" + container);
						}
					}
					else if (args.length > i + 1 && !args[i + 1].equals("o") && !args[i + 1].equals("i") || !args[i + 1].equals("s")) {
						String name = args[i + 1];
						Container container = service.loadContainer(name);
						i++;
						if (container == null && args.length > i + 1 && !args[i + 1].equals("create")) {
							LOG.error("container " + name + " does not exist");
							System.exit(1);
						}
						if (args.length > i + 1 && !args[i + 1].equals("o") && !args[i + 1].equals("i") || !args[i + 1].equals("s")) {
							String operation = args[i + 1];
							switch (operation) {
							case "start":
								LOG.info("starting container=" + container);
								service.startContainer(name);
								break;
							case "stop":
								LOG.info("stopping container=" + container);
								service.stopContainer(name);
								break;
							case "create":
								LOG.info("creating new container=" + name);
								service.createContainer(name, "images:ubuntu/jammy");
								break;
							case "delete":
								LOG.info("deleting container=" + container);
								service.deleteContainer(name);
								break;
							case "snaps":
								LOG.info("Snapshots for container=" + container);
								LOG.info(service.loadSnapshotMap(container).values());
								break;
							case "file":
								if (args.length > i + 2 && !args[i + 2].equals("o") && !args[i + 2].equals("i") || !args[i + 2].equals("s")) {
									String filepath = args[i + 2];
									LOG.info("Getting file " + filepath + " for container=" + container);
									LOG.info(service.loadFile(container.getName(), filepath));
								}
								else {
									LOG.warn("Cannot get file for container=" + container + ". Filepath not provided");
								}
								break;
							default:
								LOG.warn("Unknown container operation: " + operation);
								System.exit(1);
							}
						}
						else {
							LOG.info("container=" + container);
						}
					}
				}
				else if (args[i].equals("i")) {
					LOG.info("");
					Map<String, Image> images = service.loadImageMap();
					if (args.length - 1 == i || args[i + 1].equals("o") || args[i + 1].equals("c") || args[i + 1].equals("s")) {
						LOG.info("images=" + images.size());
						for (Image image : images.values()) {
							LOG.info("image=" + image);
						}
					}
					else if (args.length > i + 1 && !args[i + 1].equals("o") && !args[i + 1].equals("c") || !args[i + 1].equals("s")) {
						String name = args[i + 1];
						for (String key : images.keySet()) {
							if (key.contains(name)) {
								LOG.info("image=" + images.get(key));
							}
						}
						i++;
					}
				}
				else if (args[i].equals("o")) {
					LOG.info("");
					if (args.length - 1 == i || args[i + 1].equals("i") || args[i + 1].equals("c") || args[i + 1].equals("s")) {
						Collection<Operation> operations = service.loadOperationMap().values();
						LOG.info("operations=" + operations.size());
						for (Operation operation : operations) {
							LOG.info("operation=" + operation);
						}
					}
					else if (args.length > i + 1 && !args[i + 1].equals("i") && !args[i + 1].equals("c") || !args[i + 1].equals("s")) {
						String name = args[i + 1];
						Operation operation = service.loadOperation(name);
						LOG.info("operation=" + operation);
						i++;
					}
				}
				else {
					if (StringUtils.isBlank(remoteHostAndPort)) {
						remoteHostAndPort = args[i];
						LxdServerCredential credential = new LxdServerCredential(remoteHostAndPort);
						service.setLxdServerCredential(credential);
					}
				}
			}
		} catch (Exception e) {
			LOG.error(e, e);
		}
		LOG.info("LXC DONE");
	}

}
