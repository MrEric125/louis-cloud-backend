

package com.louis.core.entity.generator;



/**
 * FrameworkID 的保存器.
 *
 * @author John·Louis
 */
public class IncrementIdGenerator implements IdGenerator {


	private static Long serviceId = null;

	/**
	 * Gets service id.
	 *
	 * @return the service id
	 */
	public static Long getServiceId() {
		return serviceId;
	}

	/**
	 * Sets service id.
	 *
	 * @param serviceId the service id
	 */
	public static void setServiceId(Long serviceId) {
		IncrementIdGenerator.serviceId = serviceId;
	}

	@Override
	public Long nextId() {
		return null;
	}
}
