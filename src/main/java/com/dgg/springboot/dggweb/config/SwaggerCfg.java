package com.dgg.springboot.dggweb.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 配置swagger
 */
@Configuration
@EnableSwagger2
public class SwaggerCfg {



	@Bean
	public Docket swaggerPlugin(){
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build();
	}

	public ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				.title("英雄联盟测试战场")
				.description(CONTENT)
				.termsOfServiceUrl("https://mvnrepository.com/")//baseURL
				.version("1.0.0").build();
	}

	private static final String CONTENT =
			"一曲终了、繁花散尽、伊人已逝，只余一声空叹。----- 死亡歌颂者\n" +
			"只有飞速的旋转，才可以止住我的泪水，忘记你的模样。 -----不祥之刃\n" +
			"物是人非，可我依旧穿着嫁衣，在黑夜中寻找你的身影。 ---------寡妇制造者\n" +
			"我对你的爱就如闪电，狂暴而剧烈，飞出的飞镖是向你传达的思念。------狂暴之心\n" +
			"每一张牌，都是对你的一份思念，我赌赢了所有，却赢不回你的爱。 --------卡牌大师\n" +
			"亡命天涯，只是为了追寻你的足迹，却不想命运的捉弄，总是让你我天各一方。------法外狂徒\n" +
			"下了手中的武器，我知道你已厌倦，目送你离开，亮起黄昏的路灯，照亮你回家的路。 --------武器大师\n"+
			"我蒙上自己的双眼，只想记住最后看你的那一眼。 我刺瞎自己的双眼 只为记住那逝去的红颜。-----盲僧\n" +
			"邪恶的外表，其实并不是我的内心，你总是说我困住了你，可是，我若是不困住你，你会驻足么？ -------邪恶小法师\n" +
			"我自人类诞生,却被人类所抛弃...孤独的徘徊于世间,却与世间的一切格格不入...于是，我只能试图抓住每个遇到的生命,去倾诉那颗从不被理解的心. -------蒸汽机器人\n" +
			"我愚蠢的以为，头上的金箍圈可以圈住你所有的爱，可惜我手中的金箍棒改变不了那个开始，也决定不了这个结局，根本没有齐天大圣，我只是一只猴子。 -------齐天大圣";


}
