package profit.login.question_board.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardWriteResponse {
    private String message;
    private String nextUrl;
}

