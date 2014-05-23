package com.github.ambry.messageformat;

import com.github.ambry.utils.Utils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Basic tests for BlobProperties
 */
public class BlobPropertiesTest {
  @Test
  public void basicTest() {
    final int blobSize = 100;
    final String serviceId = "ServiceId";
    final String ownerId = "OwnerId";
    final String contentType = "ContentType";
    final int timeToLiveInSeconds = 144;

    BlobProperties blobProperties;

    blobProperties = new BlobProperties(blobSize, serviceId);
    System.out.println(blobProperties.toString()); // Provide example of BlobProperties.toString()
    assertEquals(blobProperties.getBlobSize(), blobSize);
    assertEquals(blobProperties.getServiceId(), serviceId);
    assertEquals(blobProperties.getOwnerId(), null);
    assertEquals(blobProperties.getContentType(), null);
    assertFalse(blobProperties.isPrivate());
    assertTrue(blobProperties.getTimeToLiveInSeconds() == Utils.Infinite_Time);
    assertTrue(blobProperties.getCreationTimeInMs() > 0);
    assertTrue(blobProperties.getCreationTimeInMs() <= System.currentTimeMillis());

    blobProperties = new BlobProperties(blobSize, serviceId, ownerId, contentType, true);
    System.out.println(blobProperties.toString()); // Provide example of BlobProperties.toString()
    assertEquals(blobProperties.getBlobSize(), blobSize);
    assertEquals(blobProperties.getServiceId(), serviceId);
    assertEquals(blobProperties.getOwnerId(), ownerId);
    assertEquals(blobProperties.getContentType(), contentType);
    assertTrue(blobProperties.isPrivate());
    assertTrue(blobProperties.getTimeToLiveInSeconds() == Utils.Infinite_Time);
    assertTrue(blobProperties.getCreationTimeInMs() > 0);
    assertTrue(blobProperties.getCreationTimeInMs() <= System.currentTimeMillis());

    blobProperties = new BlobProperties(blobSize, serviceId, ownerId, contentType, true, timeToLiveInSeconds);
    System.out.println(blobProperties.toString()); // Provide example of BlobProperties.toString()
    assertEquals(blobProperties.getBlobSize(), blobSize);
    assertEquals(blobProperties.getServiceId(), serviceId);
    assertEquals(blobProperties.getOwnerId(), ownerId);
    assertEquals(blobProperties.getContentType(), contentType);
    assertTrue(blobProperties.isPrivate());
    assertTrue(blobProperties.getTimeToLiveInSeconds() == timeToLiveInSeconds);
    assertTrue(blobProperties.getCreationTimeInMs() > 0);
    assertTrue(blobProperties.getCreationTimeInMs() <= System.currentTimeMillis());
  }
}