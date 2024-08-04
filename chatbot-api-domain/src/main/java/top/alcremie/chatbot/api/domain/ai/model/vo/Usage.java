package top.alcremie.chatbot.api.domain.ai.model.vo;

/**
 * @author Alcremie
 * @description
 * @create 2024/8/4
 */
public class Usage {
    private int completion_tokens;

    private int prompt_tokens;

    private int total_tokens;

    public void setCompletion_tokens(int completion_tokens){
        this.completion_tokens = completion_tokens;
    }
    public int getCompletion_tokens(){
        return this.completion_tokens;
    }
    public void setPrompt_tokens(int prompt_tokens){
        this.prompt_tokens = prompt_tokens;
    }
    public int getPrompt_tokens(){
        return this.prompt_tokens;
    }
    public void setTotal_tokens(int total_tokens){
        this.total_tokens = total_tokens;
    }
    public int getTotal_tokens(){
        return this.total_tokens;
    }
}
