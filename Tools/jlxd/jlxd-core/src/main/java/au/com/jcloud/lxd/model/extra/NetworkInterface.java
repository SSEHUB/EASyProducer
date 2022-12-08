package au.com.jcloud.lxd.model.extra;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by david.vittor on 12/07/16.
 *
 * "network": {
 * "eth0":{
 * "addresses":[{"family":"inet","address":"10.1.1.23","netmask":"24","scope":"global"}],
 * "counters":{"bytes_received":29123748,"bytes_sent":1563051,"packets_received":135107,"packets_sent":913},
 * "hwaddr":"00:16:3e:14:ea:2f",
 * "host_name":"vethI9WJG9",
 * "mtu":1500,
 * "state":"up",
 * "type":"broadcast"
 * },
 * "lo":{
 * "addresses":[{"family":"inet","address":"127.0.0.1","netmask":"8","scope":"local"},{"family":"inet6","address":"::1","netmask":"128","scope":"local"}],
 * "counters":{"bytes_received":1584148,"bytes_sent":1584148,"packets_received":995,"packets_sent":995},
 * "hwaddr":"",
 * "host_name":"",
 * "mtu":65536,
 * "state":"up",
 * "type":"loopback"
 * }
 * },
 */
public class NetworkInterface {
	public static final String ADDRESS_FAMILY = "family";
	public static final String ADDRESS_ADDRESS = "address";
	public static final String ADDRESS_NETMASK = "netmask";
	public static final String ADDRESS_SCOPE = "scope";

	private Map<IPType, Address> addressMap = new HashMap<IPType, Address>();
	private Map<String, String>[] addresses;
	private Map<String, String> counters;
	private String macAddress;
	private int mtu;
	private String state;
	private String type;

	@Override
	public String toString() {
		return "ip=" + getIp4Address() + " state=" + state + " type=" + type;
	}

	public String getIp4Address() {
		return getAddressDataMap().get(IPType.IP4) != null ? getAddressDataMap().get(IPType.IP4).getAddress() : StringUtils.EMPTY;
	}

	enum IPType {
		IP4,
		IP6
	}

	class Address {
		private IPType family;
		private String address;
		private int netmask;
		private String scope;

		public IPType getFamily() {
			return family;
		}

		public void setFamily(IPType family) {
			this.family = family;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public int getNetmask() {
			return netmask;
		}

		public void setNetmask(int netmask) {
			this.netmask = netmask;
		}

		public String getScope() {
			return scope;
		}

		public void setScope(String scope) {
			this.scope = scope;
		}
	}

	public Map<IPType, Address> getAddressDataMap() {
		if (!addressMap.isEmpty()) {
			return addressMap;
		}
		for (Map<String, String> addressData : addresses) {
			IPType ipType = IPType.IP4;
			for (String key : addressData.keySet()) {
				if (key.equals(ADDRESS_FAMILY)) {
					String value = addressData.get(key);
					if (value.equals("inet6")) {
						ipType = IPType.IP6;
					}
					Address address = addressMap.get(ipType);
					if (address == null) {
						address = new Address();
						addressMap.put(ipType, address);
					}
					address.family = ipType;
				}
				else if (key.equals(ADDRESS_ADDRESS)) {
					Address address = addressMap.get(ipType);
					if (address == null) {
						address = new Address();
						addressMap.put(ipType, address);
					}
					address.address = addressData.get(key);
				}
				else if (key.equals(ADDRESS_NETMASK)) {
					Address address = addressMap.get(ipType);
					if (address == null) {
						address = new Address();
						addressMap.put(ipType, address);
					}
					address.netmask = Integer.parseInt(addressData.get(key));
				}
				else if (key.equals(ADDRESS_SCOPE)) {
					Address address = addressMap.get(ipType);
					if (address == null) {
						address = new Address();
						addressMap.put(ipType, address);
					}
					address.scope = addressData.get(key);
				}
			}
		}
		return addressMap;
	}

	public Map<String, String>[] getAddresses() {
		return addresses;
	}

	public void setAddresses(Map<String, String>[] addresses) {
		this.addresses = addresses;
	}

	public Map<String, String> getCounters() {
		return counters;
	}

	public void setCounters(Map<String, String> counters) {
		this.counters = counters;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public int getMtu() {
		return mtu;
	}

	public void setMtu(int mtu) {
		this.mtu = mtu;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
