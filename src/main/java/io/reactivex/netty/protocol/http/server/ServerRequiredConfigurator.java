/*
 * Copyright 2014 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.reactivex.netty.protocol.http.server;

import io.netty.channel.ChannelPipeline;
import io.reactivex.netty.pipeline.PipelineConfigurator;

/**
 *
 * @param <I> The type of the content of request.
 * @param <O> The type of the content of response.
 *
 * @author Nitesh Kant
 */
class ServerRequiredConfigurator<I, O> implements PipelineConfigurator<HttpRequest<I>, HttpResponse<O>> {

    public static final String REQUEST_RESPONSE_CONVERTER_HANDLER_NAME = "request-response-converter";

    @Override
    public void configureNewPipeline(ChannelPipeline pipeline) {
        pipeline.addLast(REQUEST_RESPONSE_CONVERTER_HANDLER_NAME, new ServerRequestResponseConverter());
    }
}
