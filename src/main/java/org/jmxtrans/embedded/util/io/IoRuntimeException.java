/*
 * Copyright (c) 2010-2016 the original author or authors
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */
package org.jmxtrans.embedded.util.io;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author <a href="mailto:cleclerc@cloudbees.com">Cyrille Le Clerc</a>
 */
public class IoRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * This method returns an instance {@link IoRuntimeException}.
     *
     * Inspired by {@code com.google.common.base.Throwables#propagate(java.lang.Throwable)}.
     * <pre>
     *     try {
     *         ...
     *     } catch (IOException e) {
     *         throw IoRuntimeException.propagate(e);
     *     }
     * </pre>
     * @param e
     */
    public static IoRuntimeException propagate(IOException e) {
        if (e instanceof FileNotFoundException) {
            return new FileNotFoundRuntimeException(e);
        } else {
            return new IoRuntimeException(e);
        }
    }

    public IoRuntimeException() {
        super();
    }

    public IoRuntimeException(String message) {
        super(message);
    }

    public IoRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    protected IoRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public IoRuntimeException(Throwable cause) {
        super(cause);
    }
}
