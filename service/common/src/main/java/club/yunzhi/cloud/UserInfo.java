package club.yunzhi.cloud;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class UserInfo {

    private Long id;

    private String username;

    private String email;
}
