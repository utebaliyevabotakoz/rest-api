package lombok;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@Data
public class UsersResponseDto {

    private Integer page;

    @JsonProperty("per_page")
    private Integer perPage;

    private Integer total;

    @JsonProperty("total_pages")
    private Integer totalPages;

    @JsonProperty("data")
    private List<UserDto> users = new ArrayList<>();

    private SupportDto support;

}
