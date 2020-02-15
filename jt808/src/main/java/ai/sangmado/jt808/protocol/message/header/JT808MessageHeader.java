package ai.sangmado.jt808.protocol.message.header;

import ai.sangmado.jt808.protocol.encoding.IJT808MessageFormatter;
import ai.sangmado.jt808.protocol.enums.IMessageId;
import ai.sangmado.jt808.protocol.enums.IProtocolVersion;
import lombok.*;

/**
 * JT808 消息头
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class JT808MessageHeader<TMessageId extends IMessageId, TProtocolVersion extends IProtocolVersion>
        implements IJT808MessageFormatter<TProtocolVersion>, Cloneable {

    /**
     * 消息ID
     */
    private TMessageId messageId;

    /**
     * 消息体属性
     */
    private JT808MessageHeaderMessageContentProperty messageContentProperty;

    /**
     * 消息流水号
     * 按发送顺序从0开始循环累加。
     */
    private Integer serialNumber;

    /**
     * 消息包封装项
     * 如果消息体属性中相关标识位确定消息分包处理，则该项有内容，否则无该项。
     */
    private JT808MessageHeaderMessagePacketProperty messagePacketProperty;

    /**
     * 终端手机号
     * 2011：根据安装后终端自身的手机号转换。手机号不足12位，则在前补充数字，大陆手机号补充数字0，港澳台则根据其区号进行位数补充。
     * 2019：根据安装后终端自身的手机号转换。手机号不足位的，则在前补充数字 0。
     */
    private String phoneNumber;

    public JT808MessageHeader<TMessageId, TProtocolVersion> withMessageId(TMessageId messageId) {
        this.setMessageId(messageId);
        return this;
    }

    public JT808MessageHeader<TMessageId, TProtocolVersion> withMessageContentProperty(JT808MessageHeaderMessageContentProperty messageContentProperty) {
        this.setMessageContentProperty(messageContentProperty);
        return this;
    }

    public JT808MessageHeader<TMessageId, TProtocolVersion> withSerialNumber(int serialNumber) {
        this.setSerialNumber(serialNumber);
        return this;
    }

    public JT808MessageHeader<TMessageId, TProtocolVersion> withMessagePacketProperty(JT808MessageHeaderMessagePacketProperty messagePacketProperty) {
        this.setMessagePacketProperty(messagePacketProperty);
        return this;
    }

    public JT808MessageHeader<TMessageId, TProtocolVersion> withPhoneNumber(String phoneNumber) {
        this.setPhoneNumber(phoneNumber);
        return this;
    }

    /**
     * 克隆对象
     *
     * @return 克隆对象
     */
    @Override
    public abstract JT808MessageHeader<TMessageId, TProtocolVersion> clone();
}
