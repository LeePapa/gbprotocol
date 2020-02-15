package ai.sangmado.jt808.protocol;

import ai.sangmado.gbcommon.memory.IByteArrayPool;
import ai.sangmado.jt808.protocol.enums.IProtocolVersion;
import ai.sangmado.jt808.protocol.enums.JT808MessageContentEncryptionMode;

import java.nio.ByteOrder;
import java.nio.charset.Charset;

/**
 * 协议上下文
 */
public interface ISpecificationContext<TProtocolVersion extends IProtocolVersion> {

    /**
     * 获取协议版本
     *
     * @return 协议版本
     */
    TProtocolVersion getProtocolVersion();

    /**
     * 获取字节序
     * <p>
     * 大端（Big-Endian）字节序：高字节存于内存低地址，低字节存于内存高地址。
     * 小端（Little-Endian）字节序：低字节存于内存低地址，高字节存于内存高地址。
     *
     * @return 字节序
     */
    ByteOrder getByteOrder();

    /**
     * 获取字符集
     *
     * @return 字符集
     */
    Charset getCharset();

    /**
     * 获取消息体加密方式
     *
     * @return 消息体加密方式
     */
    JT808MessageContentEncryptionMode getMessageContentEncryptionMode();

    /**
     * 获取数组池
     *
     * @return 数组池
     */
    IByteArrayPool getByteArrayPool();
}
