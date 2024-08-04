package top.alcremie.chatbot.api.domain.zsxq.model.res;

import top.alcremie.chatbot.api.domain.zsxq.model.vo.Topics;

import java.util.List;

/**
 * @author Alcremie
 * @description
 * @create 2024/8/4
 */
public class RespData {
    private List<Topics> topics;

    public List<Topics> getTopics() {
        return topics;
    }

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }

}
