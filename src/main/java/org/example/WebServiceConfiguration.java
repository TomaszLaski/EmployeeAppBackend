package org.example;

        import io.dropwizard.Configuration;
        import com.fasterxml.jackson.annotation.JsonProperty;
        import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

        import javax.validation.Valid;
        import javax.validation.constraints.*;

public class WebServiceConfiguration extends Configuration {
    @Valid
    @NotNull
    private final SwaggerBundleConfiguration swagger = new SwaggerBundleConfiguration();

    @JsonProperty("swagger")
    public SwaggerBundleConfiguration getSwagger() {
        swagger.setResourcePackage("org.example");
        String[] schemes = {"http", "https"};
        swagger.setSchemes(schemes);
        return swagger;
    }
}
