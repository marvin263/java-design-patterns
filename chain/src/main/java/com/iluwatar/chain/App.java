/*
 * The MIT License
 * Copyright © 2014-2019 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.iluwatar.chain;

/**
 * The Chain of Responsibility pattern is a design pattern consisting of
 * 1. command objects and
 * 2. a series of processing objects.
 * <p>
 * Each processing object contains logic that defines the types of command objects that it can handle;
 * 每个 处理对象(processing object) 包含有 (定义 其可处理命令对象(command objects)的类型) 的逻辑
 * <p>
 * the rest are passed to the next processing object in the chain.
 * <p>
 * A mechanism also exists for adding new processing objects to the end of this chain.
 *
 * <p>In this example we organize the request handlers ({@link RequestHandler}) into a chain where
 * each handler has a chance to act on the request on its turn（独立地）.
 * <p>
 * Here the king ({@link OrcKing}) makes requests and
 * the military orcs ({@link OrcCommander}, {@link OrcOfficer}, {@link OrcSoldier}) form（构成了） the handler chain.
 * <p>
 * OrcCommander-->OrcOfficer-->OrcSoldier 构成了责任链
 */
public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        var king = new OrcKing();
        king.makeRequest(new Request(RequestType.DEFEND_CASTLE, "defend castle"));
        king.makeRequest(new Request(RequestType.TORTURE_PRISONER, "torture prisoner"));
        king.makeRequest(new Request(RequestType.COLLECT_TAX, "collect tax"));
    }
}
