package com.redhat.demo;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() {
        Router router = Router.router(vertx);
        
        router.get("/api/v1/hello").handler(this::helloVertx);

        router.get("/api/v1/hello/:name").handler(this::helloName);

        vertx.createHttpServer().requestHandler(router).listen(8888);
    }
        void helloVertx(RoutingContext ctx) {
            ctx.request().response().end("Hello Vertx world!");
        }

        void helloName(RoutingContext ctx) {
            String name = ctx.pathParam("name");
            ctx.request().response().end(String.format("Hello %s!", name));
        }
        
        // vertx.createHttpServer().requestHandler(req -> {
        //     if(req.path().startsWith("/hello")) {
        //         req.response().end("Hello, Vertx worl!d");
        //     } else if (req.path().startsWith("/about")) {
        //         req.response().end("First vertx project");
        //     }
        // }).listen(8888);

}
