package au.com.jcloud.lxd.model;

import java.util.Map;

/**
 * Created by david.vitor on 11/07/16.
 *
 {
 "type": "sync",
 "status": "Success",
 "status_code": 200,
 "metadata": {
 "name": "docker",
 "config": {
 "linux.kernel_modules": "overlay, nf_nat",
 "security.nesting": "true"
 },
 "description": "Profile supporting docker in containers",
 "devices": {
 "aadisable": {
 "path": "/sys/module/apparmor/parameters/enabled",
 "source": "/dev/null",
 "type": "disk"
 },
 "fuse": {
 "path": "/dev/fuse",
 "type": "unix-char"
 }
 }
 }
 }
 */
public class Profile {
    private String name;
    private String description;
    private Map<String,Object> devices;
    private Map<String,Object> config;

    @Override
    public String toString() {
        return "ProfileMetaData{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", devices=" + devices +
                ", config=" + config +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Object> getDevices() {
        return devices;
    }

    public void setDevices(Map<String, Object> devices) {
        this.devices = devices;
    }

    public Map<String, Object> getConfig() {
        return config;
    }

    public void setConfig(Map<String, Object> config) {
        this.config = config;
    }
}
