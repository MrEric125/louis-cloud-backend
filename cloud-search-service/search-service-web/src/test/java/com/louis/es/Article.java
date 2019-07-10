package com.louis.es;

import lombok.*;

/**
 * @author John·Louis
 * @date create in 2019/7/9
 * description:
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private long id;
    private String title;
    private String content;

}
