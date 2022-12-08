package au.com.jcloud.lxd.model;

import java.util.Date;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

import au.com.jcloud.lxd.model.extra.Config;
import au.com.jcloud.lxd.util.FormatUtils;

/**
 * Created by david.vittor on 11/07/16.
 *
 * JSON format is:
 * 
 * <pre>
 * {@code
 * {
 *  "architecture":"x86_64",
 *  "config":{
 *      "volatile.base_image":"255cca628a372f3f3631637685b6ebcd31d0fde53ca6b880bc20019aa77c50d9",
 *      "volatile.eth0.hwaddr":"00:16:3e:14:ea:2f",
 *      "volatile.last_state.idmap":"[
 *          {\"Isuid\":true,\"Isgid\":false,\"Hostid\":165536,\"Nsid\":0,\"Maprange\":65536},
 *          {\"Isuid\":false,\"Isgid\":true,\"Hostid\":165536,\"Nsid\":0,\"Maprange\":65536}
 *      ]"
 *  },
 *  "created_at":"2016-07-07T22:27:37+10:00",
 *  "devices":{
 *      "root":{"path":"/","type":"disk"}
 *  },
 *  "ephemeral":false,
 *  "expanded_config":{
 *      "volatile.base_image":"255cca628a372f3f3631637685b6ebcd31d0fde53ca6b880bc20019aa77c50d9",
 *      "volatile.eth0.hwaddr":"00:16:3e:14:ea:2f",
 *      "volatile.last_state.idmap":"[
 *          {\"Isuid\":true,\"Isgid\":false,\"Hostid\":165536,\"Nsid\":0,\"Maprange\":65536},
 *          {\"Isuid\":false,\"Isgid\":true,\"Hostid\":165536,\"Nsid\":0,\"Maprange\":65536}
 *      ]"
 *  },
 *  "expanded_devices":{
 *      "eth0":{"name":"eth0","nictype":"bridged","parent":"br0","type":"nic"},
 *      "root":{"path":"/","type":"disk"}
 *  },
 *  "name":"www",
 *  "profiles":["default"],
 *  "stateful":false,
 *  "status":"Running",
 *  "status_code":103,
 *  "state":{
 *      "status":"Running",
 *      "status_code":103,
 *      "disk":{"root":{"usage":56976384}},
 *      "memory":{"usage":123080704,"usage_peak":419868672,"swap_usage":0,"swap_usage_peak":0},
 *      "network": {
 *          "eth0":{"addresses":[{"family":"inet","address":"10.1.1.23","netmask":"24","scope":"global"}],
 *          "counters":{"bytes_received":29123748,"bytes_sent":1563051,"packets_received":135107,"packets_sent":913},
 *          "hwaddr":"00:16:3e:14:ea:2f",
 *          "host_name":"vethI9WJG9",
 *          "mtu":1500,
 *          "state":"up",
 *          "type":"broadcast"},
 *          "lo":{"addresses":[{"family":"inet","address":"127.0.0.1","netmask":"8","scope":"local"},{"family":"inet6","address":"::1","netmask":"128","scope":"local"}],
 *          "counters":{"bytes_received":1584148,"bytes_sent":1584148,"packets_received":995,"packets_sent":995},
 *          "hwaddr":"",
 *          "host_name":"",
 *          "mtu":65536,
 *          "state":"up",
 *          "type":"loopback"}
 *      },
 *      "pid":4128,
 *      "processes":97
 *  },
 *  "snapshots":[]
 * }
 * </pre>
 */
public class Container {
	private String architecture;
	private String name;
	private boolean stateful;
	private boolean ephemeral;
	@SerializedName("created_at")
	private Date createdDate;
	private String status;
	@SerializedName("status_code")
	private int statusCode;
	private Config config;
	@SerializedName("expanded_config")
	private Config expandedConfig;
	private Map<String,Object> devices;
	@SerializedName("expanded_devices")
	private Map<String,Object> expandedDevices;
	private State state;

	public String getCreatedDateAsIsoDateTime() {
		return FormatUtils.convertDateTimeToISO(createdDate);
	}
	
	@Override
	public String toString() {
		return "name=" + name + " status=" + status + " statusCode=" + statusCode + " stateful=" + stateful + " date=" + createdDate + " config=" + config + " state=" + state;
	}

	public String getArchitecture() {
		return architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStateful() {
		return stateful;
	}

	public void setStateful(boolean stateful) {
		this.stateful = stateful;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isEphemeral() {
		return ephemeral;
	}

	public void setEphemeral(boolean ephemeral) {
		this.ephemeral = ephemeral;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public Config getExpandedConfig() {
		return expandedConfig;
	}

	public void setExpandedConfig(Config expandedConfig) {
		this.expandedConfig = expandedConfig;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Map<String, Object> getDevices() {
		return devices;
	}

	public void setDevices(Map<String, Object> devices) {
		this.devices = devices;
	}

	public Map<String, Object> getExpandedDevices() {
		return expandedDevices;
	}

	public void setExpandedDevices(Map<String, Object> expandedDevices) {
		this.expandedDevices = expandedDevices;
	}
}
