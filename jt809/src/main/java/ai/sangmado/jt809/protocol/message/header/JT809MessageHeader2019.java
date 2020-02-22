package ai.sangmado.jt809.protocol.message.header;

import ai.sangmado.jt809.protocol.ISpecificationContext;
import ai.sangmado.jt809.protocol.encoding.IJT809MessageBufferReader;
import ai.sangmado.jt809.protocol.encoding.IJT809MessageBufferWriter;
import ai.sangmado.jt809.protocol.enums.JT809MessageContentEncryptionMode;
import ai.sangmado.jt809.protocol.enums.JT809MessageId;
import ai.sangmado.jt809.protocol.enums.JT809ProtocolVersion;
import ai.sangmado.jt809.protocol.exceptions.UnsupportedJT809OperationException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static ai.sangmado.jt809.protocol.enums.JT809ProtocolVersion.V2019;

@Getter
@Setter
@NoArgsConstructor
public class JT809MessageHeader2019 extends JT809MessageHeader {
    public static final JT809ProtocolVersion PROTOCOL_VERSION = V2019;

    /**
     * 发送消息时的系统UTC时间，长度为8个字节
     * <p>
     * Since {@link JT809ProtocolVersion#V2019}
     * <p>
     * 如2010-1-10 9:7:54的UTC值为1263085674，其在协议中表示为0x000000004B49286A
     */
    private Long timestamp;

    @Builder
    public JT809MessageHeader2019(
            Long messageLength,
            Long messageSequenceNumber,
            JT809MessageId messageId,
            Long gnssCenterId,
            JT809ProtocolVersion protocolVersion,
            JT809MessageContentEncryptionMode encryptionMode,
            Long encryptionKey,
            Long timestamp) {
        super(messageLength, messageSequenceNumber, messageId, gnssCenterId, protocolVersion, encryptionMode, encryptionKey);
        setTimestamp(timestamp);
    }

    @Override
    public JT809MessageHeader clone() {
        try {
            return JT809MessageHeader2019.builder()
                    .messageLength(this.getMessageLength())
                    .messageSequenceNumber(this.getMessageSequenceNumber())
                    .messageId(this.getMessageId())
                    .gnssCenterId(this.getGnssCenterId())
                    .protocolVersion(this.getProtocolVersion())
                    .encryptionMode(this.getEncryptionMode())
                    .encryptionKey(this.getEncryptionKey())
                    .timestamp(this.getTimestamp())
                    .build();
        } catch (Exception ex) {
            throw new UnsupportedJT809OperationException("克隆对象失败", ex);
        }
    }

    @Override
    public void serialize(ISpecificationContext ctx, IJT809MessageBufferWriter writer) {
        writer.writeWord(getMessageId().getValue());

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT809MessageBufferReader reader) {
        setMessageId(JT809MessageId.cast(reader.readWord()));

    }

    public static JT809MessageHeader2019 decode(ISpecificationContext ctx, IJT809MessageBufferReader reader) {
        JT809MessageHeader2019 header = new JT809MessageHeader2019();
        header.deserialize(ctx, reader);
        return header;
    }
}