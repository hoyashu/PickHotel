package com.example.common;

/*
    스웨거 설정 : API 문서 관리 프레임워크
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

/*
    작성자 : 김소진
    작성일 : 2021-12-31
    내용 : 강사님 코드 - swagger-ui.html 접근시, swagger켜지게 하는 부분
*/

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    private static final Contact contact = new Contact("kso", "https://www.megazone.com/", "ks@mz.co.kr");
    private static final Set<String> sets = new HashSet<>(Arrays.asList("application/json"));


    @Bean
    public LinkDiscoverers discoverers() {
        List<LinkDiscoverer> plugins = new ArrayList<LinkDiscoverer>();
        plugins.add(new CollectionJsonLinkDiscoverer());
        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));

    }


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/api.*"))
                .build()
                .apiInfo(apiInfo())
                .produces(sets)
                .consumes(sets);

    }

    private ApiInfo apiInfo() {
        String description = "숙소 REST API 목록입니다.";
        return new ApiInfoBuilder()
                .title("ROOM REST API List")
                .description(description)
                .version("1.0")
                .build();
    }


}