package eu.qualiMaster.signal;

import org.apache.log4j.Logger;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;
import com.netflix.curator.framework.CuratorFramework;

public abstract class AbstractSignalConnection implements Watcher {
    final static Logger logger = Logger.getLogger(AbstractSignalConnection.class);
    static final String namespace = "QM2.devel";
    protected String name;
    protected CuratorFramework client;
    protected SignalListener listener;

protected void initWatcher() throws Exception {
    Stat stat = this.client.checkExists().usingWatcher(this).forPath(this.name);
     if (stat == null) {
         String path = this.client.create().creatingParentsIfNeeded().forPath(this.name);
     }
}
public void process(WatchedEvent we) {
    try {
        this.client.checkExists().usingWatcher(this).forPath(this.name);
     } catch (Exception ex) {
         logger.error("Error renewing watch."+ ex);
     }

    switch (we.getType()) {
     case NodeCreated:
        logger.info("Node created.");
        break;
     case NodeDataChanged:
        logger.info("Received signal.");
        try {
            this.listener.onSignal(this.client.getData().forPath(we.getPath()));
        } catch (Exception e) {
            logger.error("Warning: Unable to process signal."+e);
        }
        break;
     case NodeDeleted:
        logger.info("NodeDeleted");
        break;
    }
}

public void close() {
    this.client.close();
}

public void send(String toPath, byte[] signal) throws Exception {
    Stat stat = this.client.checkExists().forPath(toPath);
    if (stat == null) {
        String path = this.client.create().creatingParentsIfNeeded().forPath(toPath);
    }
    this.client.setData().forPath(toPath, signal);
}
}
