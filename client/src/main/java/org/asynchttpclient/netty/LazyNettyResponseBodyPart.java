/*
 * Copyright (c) 2014 AsyncHttpClient Project. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package org.asynchttpclient.netty;

import io.netty.buffer.ByteBuf;

import java.nio.ByteBuffer;

import org.asynchttpclient.netty.util.ByteBufUtils;

/**
 * A callback class used when an HTTP response body is received.
 */
public class LazyNettyResponseBodyPart extends NettyResponseBodyPart {

    private final ByteBuf buf;

    public LazyNettyResponseBodyPart(ByteBuf buf, boolean last) {
        super(last);
        this.buf = buf;
    }

    public ByteBuf getBuf() {
        return buf;
    }

    @Override
    public int length() {
        return buf.readableBytes();
    }
    
    /**
     * Return the response body's part bytes received.
     * 
     * @return the response body's part bytes received.
     */
    @Override
    public byte[] getBodyPartBytes() {
        return ByteBufUtils.byteBuf2Bytes(buf.duplicate());
    }

    @Override
    public ByteBuffer getBodyByteBuffer() {
        return buf.nioBuffer();
    }
}
