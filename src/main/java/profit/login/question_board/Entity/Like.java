package profit.login.question_board.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import profit.login.entity.User;
import profit.login.question_board.Entity.Board;
import profit.login.question_board.Entity.Reply;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "\"like\"")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)

    private User user;      // 좋아요를 누른 유저

    @ManyToOne(fetch = FetchType.LAZY)

    private Board board;    // 좋아요가 추가된 게시글

    @ManyToOne(fetch = FetchType.LAZY)

    private Reply reply;

}