package org.kultpower;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
@Component
public class StaticResourceConfiguration extends WebMvcConfigurerAdapter {

    @Value("${app.resources}")
    private String staticResources;

    @Autowired
    private URLConfiguration urlConfiguration;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/ext/**")
                .addResourceLocations("file:" + staticResources);

        super.addResourceHandlers(registry);


    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("addInterceptors aufgerufen!");
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                return true;
            }
            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
                for (URLConfiguration.URLS url: urlConfiguration.getUrls()) {
                    modelAndView.addObject("URL_" + url.name(), url.value);
                }

                System.out.println("postHandle aufgerufen!");
            }
            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
            }
        });
        super.addInterceptors(registry);
    }

    public String getStaticResources() {
        return staticResources;
    }

    public void setStaticResources(String staticResources) {
        this.staticResources = staticResources;
    }

    public URLConfiguration getUrlConfiguration() {
        return urlConfiguration;
    }

    public void setUrlConfiguration(URLConfiguration urlConfiguration) {
        this.urlConfiguration = urlConfiguration;
    }
}
