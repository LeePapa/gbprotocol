package ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * 终端􏰉􏱀􏰏􏰙􏱁位置信息汇报 - 位置附加信息 - 注册器
 */
public class JT808_Message_Content_0x8103_ParameterItemRegistration {

    private static final Map<JT808_Message_Content_0x8103_ParameterItemId, BiFunction<ISpecificationContext, IJT808MessageBufferReader, JT808_Message_Content_0x8103_ParameterItem>> decoders = new HashMap<>(300);

    public static Map<JT808_Message_Content_0x8103_ParameterItemId, BiFunction<ISpecificationContext, IJT808MessageBufferReader, JT808_Message_Content_0x8103_ParameterItem>> getDecoders() {
        return decoders;
    }

    public static void register(JT808_Message_Content_0x8103_ParameterItemId messageId, BiFunction<ISpecificationContext, IJT808MessageBufferReader, JT808_Message_Content_0x8103_ParameterItem> contentDecoder) {
        decoders.put(messageId, contentDecoder);
    }

    static {
        register(JT808_Message_Content_0x8103_PI_0x0001.PARAMETER_ITEM_ID, JT808_Message_Content_0x8103_PI_0x0001::decode);
        register(JT808_Message_Content_0x8103_PI_0x0002.PARAMETER_ITEM_ID, JT808_Message_Content_0x8103_PI_0x0002::decode);
        register(JT808_Message_Content_0x8103_PI_0x0003.PARAMETER_ITEM_ID, JT808_Message_Content_0x8103_PI_0x0003::decode);
        register(JT808_Message_Content_0x8103_PI_0x0004.PARAMETER_ITEM_ID, JT808_Message_Content_0x8103_PI_0x0004::decode);
        register(JT808_Message_Content_0x8103_PI_0x0005.PARAMETER_ITEM_ID, JT808_Message_Content_0x8103_PI_0x0005::decode);
        register(JT808_Message_Content_0x8103_PI_0x0006.PARAMETER_ITEM_ID, JT808_Message_Content_0x8103_PI_0x0006::decode);
        register(JT808_Message_Content_0x8103_PI_0x0007.PARAMETER_ITEM_ID, JT808_Message_Content_0x8103_PI_0x0007::decode);
    }
}
