package top.alcremie.chatbot.api.domain.zsxq.model.req;

/**
 * @author Alcremie
 * @description 请求问答接口信息
 * @create 2024/8/4
 */
public class AnswerReq {
    private ReqData req_data;

    public AnswerReq(ReqData req_data) {
        this.req_data = req_data;
    }

    public ReqData getReq_data() {
        return req_data;
    }

    public void setReq_data(ReqData req_data) {
        this.req_data = req_data;
    }
}
