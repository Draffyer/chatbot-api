package top.alcremie.chatbot.api.domain.ai.service;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.alcremie.chatbot.api.domain.ai.IOpenAI;
import top.alcremie.chatbot.api.domain.ai.model.aggregates.Root;
import top.alcremie.chatbot.api.domain.ai.model.vo.Choices;
import top.alcremie.chatbot.api.domain.ai.model.vo.Message;

import java.io.IOException;
import java.util.List;

/**
 * @author Alcremie
 * @description
 * @create 2024/8/4
 */
@Service
public class OpenAI implements IOpenAI {

    private Logger logger = LoggerFactory.getLogger(OpenAI.class);

    @Value("${chatbot-api.openAiKey}")
    private String openAiKey;
    @Override
    public String doChatGPT(String question) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://open.bigmodel.cn/api/paas/v4/chat/completions");
        post.addHeader("Content-Type","application/json");
        post.addHeader("Authorization","Bearer "+openAiKey);

        String paramJson = "{\n" +
                "    \"model\": \"glm-4\",\n" +
                "    \"messages\": [\n" +
                "        {\n" +
                "            \"role\": \"user\",\n" +
                "            \"content\": \""+question+"\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);

        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String jsonStr = EntityUtils.toString(response.getEntity());
            Root aiAnswer = JSON.parseObject(jsonStr, Root.class);
            StringBuilder answers = new StringBuilder();
            List<Choices> choices = aiAnswer.getChoices();
            for(Choices choice:choices){
                Message message = choice.getMessage();
                answers.append(message.getContent());
            }
            return answers.toString();

        }else {
            throw new RuntimeException("api.openai.com Err Code is"+response.getStatusLine().getStatusCode());
        }
    }
}
