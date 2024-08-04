package top.alcremie.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Alcremie
 * @description 单元测试
 * @create 2024/8/4
 */
public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/48888551425458/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie","sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22548214448848814%22%2C%22first_id%22%3A%2218eb8c6b284114-0c775381dc7646-26001a51-1638720-18eb8c6b285b27%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E5%BC%95%E8%8D%90%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fbugstack.cn%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThlYjhjNmIyODQxMTQtMGM3NzUzODFkYzc2NDYtMjYwMDFhNTEtMTYzODcyMC0xOGViOGM2YjI4NWIyNyIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjU0ODIxNDQ0ODg0ODgxNCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22548214448848814%22%7D%2C%22%24device_id%22%3A%2218eb8c6b284114-0c775381dc7646-26001a51-1638720-18eb8c6b285b27%22%7D; zsxqsessionid=a8091cb985536845ed81d47a093dd9d6; zsxq_access_token=5AD1EEBE-02E9-CE50-88AB-B3B581B7937B_F03FF9176E0D4973; abtest_env=beta\n");
        get.addHeader("Content-Type","application/json;charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/8855185211215252/answer");
        post.addHeader("cookie","sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22548214448848814%22%2C%22first_id%22%3A%2218eb8c6b284114-0c775381dc7646-26001a51-1638720-18eb8c6b285b27%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E5%BC%95%E8%8D%90%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fbugstack.cn%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThlYjhjNmIyODQxMTQtMGM3NzUzODFkYzc2NDYtMjYwMDFhNTEtMTYzODcyMC0xOGViOGM2YjI4NWIyNyIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjU0ODIxNDQ0ODg0ODgxNCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22548214448848814%22%7D%2C%22%24device_id%22%3A%2218eb8c6b284114-0c775381dc7646-26001a51-1638720-18eb8c6b285b27%22%7D; zsxqsessionid=a8091cb985536845ed81d47a093dd9d6; zsxq_access_token=5AD1EEBE-02E9-CE50-88AB-B3B581B7937B_F03FF9176E0D4973; abtest_env=beta\n");
        post.addHeader("Content-Type","application/json;charset=UTF-8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"我还是不知道\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": true\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);

        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void test_chatGPT() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://open.bigmodel.cn/api/paas/v4/chat/completions");
        post.addHeader("Content-Type","application/json");
        post.addHeader("Authorization","Bearer eec21e20085f90c0cf54dee53849582f.qlimkhyI5slBm1Qa");

        String paramJson = "{\n" +
                "    \"model\": \"glm-4\",\n" +
                "    \"messages\": [\n" +
                "        {\n" +
                "            \"role\": \"user\",\n" +
                "            \"content\": \"给我写一个java冒泡排序代码\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);

        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }



    }

}
