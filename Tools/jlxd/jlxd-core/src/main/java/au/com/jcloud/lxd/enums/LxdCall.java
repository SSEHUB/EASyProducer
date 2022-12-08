package au.com.jcloud.lxd.enums;

import static au.com.jcloud.lxd.service.ILxdApiService.URL_GET_CERTIFICATE;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_GET_CONTAINER;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_GET_FILE;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_GET_IMAGE;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_GET_IMAGEALIAS;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_GET_NETWORK;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_GET_OPERATION;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_GET_PROFILE;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_GET_SERVERINFO;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_GET_SNAPSHOTS;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_GET_STATE;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_POST_CONTAINER_COPY;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_POST_CONTAINER_CREATE_LOCAL;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_POST_CONTAINER_CREATE_REMOTE;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_POST_CONTAINER_DELETE;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_POST_CONTAINER_EXEC;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_POST_CONTAINER_FILES;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_POST_CONTAINER_RENAME;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_POST_IMAGEALIAS_CREATE;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_POST_IMAGEALIAS_DELETE;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_POST_IMAGEALIAS_RENAME;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_POST_IMAGE_DELETE;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_POST_NETWORK_DELETE;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_POST_PROFILE_DELETE;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_POST_SNAPSHOT_CREATE;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_POST_SNAPSHOT_DELETE;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_POST_SNAPSHOT_RENAME;
import static au.com.jcloud.lxd.service.ILxdApiService.URL_PUT_CONTAINER_STATE;

import au.com.jcloud.lxd.model.response.AbstractResponse;
import au.com.jcloud.lxd.model.response.CertificateResponse;
import au.com.jcloud.lxd.model.response.ContainerResponse;
import au.com.jcloud.lxd.model.response.FileResponse;
import au.com.jcloud.lxd.model.response.ImageAliasResponse;
import au.com.jcloud.lxd.model.response.ImageResponse;
import au.com.jcloud.lxd.model.response.NetworkResponse;
import au.com.jcloud.lxd.model.response.OperationResponse;
import au.com.jcloud.lxd.model.response.ProfileResponse;
import au.com.jcloud.lxd.model.response.ServerInfoResponse;
import au.com.jcloud.lxd.model.response.SnapshotResponse;
import au.com.jcloud.lxd.model.response.StateResponse;

public enum LxdCall {
	GET_SERVERINFO(URL_GET_SERVERINFO, ServerInfoResponse.class),
	GET_CONTAINER(URL_GET_CONTAINER, ContainerResponse.class),
	GET_IMAGE(URL_GET_IMAGE, ImageResponse.class),
	GET_IMAGEALIAS(URL_GET_IMAGEALIAS, ImageAliasResponse.class),
	GET_CERTIFICATE(URL_GET_CERTIFICATE, CertificateResponse.class),
	GET_NETWORK(URL_GET_NETWORK, NetworkResponse.class),
	GET_OPERATION(URL_GET_OPERATION, OperationResponse.class),
	GET_PROFILE(URL_GET_PROFILE, ProfileResponse.class),
	GET_STATE(URL_GET_STATE, StateResponse.class),
	GET_SNAPSHOTS(URL_GET_SNAPSHOTS, SnapshotResponse.class),
	GET_FILE(URL_GET_FILE, FileResponse.class),
	PUT_CONTAINER_STATE(URL_PUT_CONTAINER_STATE, OperationResponse.class),
	POST_CONTAINER_CREATE_REMOTE(URL_POST_CONTAINER_CREATE_REMOTE, OperationResponse.class),
	POST_CONTAINER_CREATE_LOCAL(URL_POST_CONTAINER_CREATE_LOCAL, OperationResponse.class),
	POST_CONTAINER_COPY(URL_POST_CONTAINER_COPY, OperationResponse.class),
	POST_CONTAINER_DELETE(URL_POST_CONTAINER_DELETE, OperationResponse.class),
	POST_CONTAINER_RENAME(URL_POST_CONTAINER_RENAME, OperationResponse.class),
	POST_CONTAINER_EXEC(URL_POST_CONTAINER_EXEC, OperationResponse.class),
	POST_CONTAINER_FILES(URL_POST_CONTAINER_FILES, OperationResponse.class),
	POST_SNAPSHOT_CREATE(URL_POST_SNAPSHOT_CREATE, SnapshotResponse.class),
	POST_SNAPSHOT_DELETE(URL_POST_SNAPSHOT_DELETE, SnapshotResponse.class),
	POST_SNAPSHOT_RENAME(URL_POST_SNAPSHOT_RENAME, SnapshotResponse.class),
	POST_IMAGE_DELETE(URL_POST_IMAGE_DELETE, ImageResponse.class),
	POST_IMAGEALIAS_CREATE(URL_POST_IMAGEALIAS_CREATE, ImageAliasResponse.class),
	POST_IMAGEALIAS_DELETE(URL_POST_IMAGEALIAS_DELETE, ImageAliasResponse.class),
	POST_IMAGEALIAS_RENAME(URL_POST_IMAGEALIAS_RENAME, ImageAliasResponse.class),
	POST_PROFILE_DELETE(URL_POST_PROFILE_DELETE, ProfileResponse.class),
	POST_NETWORK_DELETE(URL_POST_NETWORK_DELETE, ProfileResponse.class);

	LxdCall(String command, Class<? extends AbstractResponse> classType) {
		this.command = command;
		this.classType = classType;
	}

	private String command;
	private Class<? extends AbstractResponse> classType;

	public String getCommand() {
		return command;
	}

	public Class<? extends AbstractResponse> getClassType() {
		return classType;
	}
}