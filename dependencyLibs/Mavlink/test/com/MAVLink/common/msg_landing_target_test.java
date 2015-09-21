/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */
         
// MESSAGE LANDING_TARGET PACKING
package com.MAVLink.common;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Parser;
import com.MAVLink.ardupilotmega.CRC;
import java.nio.ByteBuffer;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
* The location of a landing area captured from a downward facing camera
*/
public class msg_landing_target_test{

public static final int MAVLINK_MSG_ID_LANDING_TARGET = 149;
public static final int MAVLINK_MSG_LENGTH = 30;
private static final long serialVersionUID = MAVLINK_MSG_ID_LANDING_TARGET;

private Parser parser = new Parser();

public CRC generateCRC(byte[] packet){
    CRC crc = new CRC();
    for (int i = 1; i < packet.length - 2; i++) {
        crc.update_checksum(packet[i] & 0xFF);
    }
    crc.finish_checksum(MAVLINK_MSG_ID_LANDING_TARGET);
    return crc;
}

public byte[] generateTestPacket(){
    ByteBuffer payload = ByteBuffer.allocate(6 + MAVLINK_MSG_LENGTH + 2);
    payload.put((byte)MAVLinkPacket.MAVLINK_STX); //stx
    payload.put((byte)MAVLINK_MSG_LENGTH); //len
    payload.put((byte)0); //seq
    payload.put((byte)255); //sysid
    payload.put((byte)190); //comp id
    payload.put((byte)MAVLINK_MSG_ID_LANDING_TARGET); //msg id
    payload.putLong((long)93372036854775807L); //time_usec
    payload.putFloat((float)73.0); //angle_x
    payload.putFloat((float)101.0); //angle_y
    payload.putFloat((float)129.0); //distance
    payload.putFloat((float)157.0); //size_x
    payload.putFloat((float)185.0); //size_y
    payload.put((byte)89); //target_num
    payload.put((byte)156); //frame
    
    CRC crc = generateCRC(payload.array());
    payload.put((byte)crc.getLSB());
    payload.put((byte)crc.getMSB());
    return payload.array();
}

@Test
public void test(){
    byte[] packet = generateTestPacket();
    for(int i = 0; i < packet.length - 1; i++){
        parser.mavlink_parse_char(packet[i] & 0xFF);
    }
    MAVLinkPacket m = parser.mavlink_parse_char(packet[packet.length - 1] & 0xFF);
    byte[] processedPacket = m.encodePacket();
    assertArrayEquals("msg_landing_target", processedPacket, packet);
}
}
        