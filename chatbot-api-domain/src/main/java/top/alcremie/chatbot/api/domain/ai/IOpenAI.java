package top.alcremie.chatbot.api.domain.ai;

import java.io.IOException;

/**
 * @author Alcremie
 * @description 语言大模型openai接口
 * @create 2024/8/4
 */
public interface IOpenAI {

    String doChatGPT(String question) throws IOException;
}
