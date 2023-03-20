//package discord.interviewer.repository;
//
//
//import notion.api.v1.NotionClient;
//

//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Repository;
//
//
//
//@Repository
//public class NotionRepository {
//    @Value("${NOTION_API_KEY}")
//    private String apiKey;
//    @Value("${NOTION_DATABASE_ID}")
//    private String databasesId;
//    private final NotionClient notionClient;
//
//    public NotionRepository() {
//        this.notionClient = new NotionClient(apiKey);
//    }
//
//}
