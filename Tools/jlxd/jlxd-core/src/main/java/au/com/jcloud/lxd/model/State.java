package au.com.jcloud.lxd.model;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

import au.com.jcloud.lxd.model.extra.NetworkInterface;
import au.com.jcloud.lxd.util.FormatUtils;

/**
 * Created by david.vittor on 12/07/16.
 *
 * "state":{
 * "status":"Running",
 * "status_code":103,
 * "disk":{"root":{"usage":56976384}},
 * "memory":{"usage":123080704,"usage_peak":419868672,"swap_usage":0,"swap_usage_peak":0},
 * "network": {
 * "eth0":{"addresses":[{"family":"inet","address":"10.1.1.23","netmask":"24","scope":"global"}],
 * "counters":{"bytes_received":29123748,"bytes_sent":1563051,"packets_received":135107,"packets_sent":913},
 * "hwaddr":"00:16:3e:14:ea:2f",
 * "host_name":"vethI9WJG9",
 * "mtu":1500,
 * "state":"up",
 * "type":"broadcast"},
 * "lo":{"addresses":[{"family":"inet","address":"127.0.0.1","netmask":"8","scope":"local"},{"family":"inet6","address":"::1","netmask":"128","scope":"local"}],
 * "counters":{"bytes_received":1584148,"bytes_sent":1584148,"packets_received":995,"packets_sent":995},
 * "hwaddr":"",
 * "host_name":"",
 * "mtu":65536,
 * "state":"up",
 * "type":"loopback"}
 * },
 * "pid":4128,
 * "processes":97
 *
 */
public class State {
	public static final String MEM_USAGE = "usage";
	public static final String MEM_USAGE_PEAK = "usage_peak";
	public static final String MEM_SWAP_USAGE = "swap_usage";
	public static final String MEM_SWAP_USAGE_PEAK = "swap_usage_peak";

	public static final int STATUS_CODE_RUNNING = 103;
	public static final int STATUS_CODE_STOPPED = 102;
	public static final int STATUS_CODE_FROZEN = 110;

	private String status;
	@SerializedName("status_code")
	private int statusCode;
	private Map<String, Map<String, String>> disk;
	private Map<String, Long> memory;
	private Map<MemoryEnum, Long> memoryData = new HashMap<MemoryEnum, Long>();
	private Map<String, NetworkInterface> network;
	int pid;
	int processes;

	@Override
	public String toString() {
		return "pid=" + pid + " status="+status+"("+statusCode+") processes=" + processes + " memory=" + getMemoryUsageInMB() + "MB/" + getMemoryPeakUsageInMB() + "MB" + " swap=" + getSwapMemoryUsageInMB() + "MB/" + getSwapMemoryPeakUsageInMB() + "MB" + " network=" + network;
	}

	enum MemoryEnum {
		USAGE, USAGE_PEAK, SWAP_USAGE, SWAP_USAGE_PEAK
	}

	public boolean isRunning() {
		return statusCode == STATUS_CODE_RUNNING;
	}

	public boolean isStopped() {
		return statusCode == STATUS_CODE_STOPPED;
	}
	
	public boolean isFrozen() {
		return statusCode == STATUS_CODE_FROZEN;
	}

	public String getMemoryUsageInMB() {
		return getMemoryInMB(MemoryEnum.USAGE);
	}
	
	public String getMemoryPeakUsageInMB() {
		return getMemoryInMB(MemoryEnum.USAGE_PEAK);
	}
	
	public String getSwapMemoryUsageInMB() {
		return getMemoryInMB(MemoryEnum.SWAP_USAGE);
	}
	
	public String getSwapMemoryPeakUsageInMB() {
		return getMemoryInMB(MemoryEnum.SWAP_USAGE_PEAK);
	}
	
	public String getMemoryInMB(MemoryEnum type) {
		getMemoryData();
		Long memoryValue = memoryData.get(type);
		return (memoryValue!=null) ? FormatUtils.convertIntegerToMB(memoryValue) : "0";
	}
	
	public Map<MemoryEnum, Long> getMemoryData() {
		if (!memoryData.isEmpty()) {
			return memoryData;
		}
		if (memory!=null) {
			for (String key : memory.keySet()) {
				if (key.equals(MEM_USAGE)) {
					memoryData.put(MemoryEnum.USAGE, memory.get(key));
				}
				else if (key.equals(MEM_USAGE_PEAK)) {
					memoryData.put(MemoryEnum.USAGE_PEAK, memory.get(key));
				}
				else if (key.equals(MEM_SWAP_USAGE)) {
					memoryData.put(MemoryEnum.SWAP_USAGE, memory.get(key));
				}
				else if (key.equals(MEM_SWAP_USAGE_PEAK)) {
					memoryData.put(MemoryEnum.SWAP_USAGE_PEAK, memory.get(key));
				}
			}
		}
		return memoryData;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Map<String, Map<String, String>> getDisk() {
		return disk;
	}

	public void setDisk(Map<String, Map<String, String>> disk) {
		this.disk = disk;
	}

	public Map<String, Long> getMemory() {
		return memory;
	}

	public void setMemory(Map<String, Long> memory) {
		this.memory = memory;
	}

	public Map<String, NetworkInterface> getNetwork() {
		return network;
	}

	public void setNetwork(Map<String, NetworkInterface> network) {
		this.network = network;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getProcesses() {
		return processes;
	}

	public void setProcesses(int processes) {
		this.processes = processes;
	}
}
