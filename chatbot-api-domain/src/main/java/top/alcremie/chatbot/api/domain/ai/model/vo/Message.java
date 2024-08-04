package top.alcremie.chatbot.api.domain.ai.model.vo;

/**
 * @author Alcremie
 * @description
 * @create 2024/8/4
 */
public class Message {
    private String content;

    private String role;

    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }
    public void setRole(String role){
        this.role = role;
    }
    public String getRole(){
        return this.role;
    }
}
