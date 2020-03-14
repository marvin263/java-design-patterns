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

package com.iluwatar.facade;

import java.util.Collection;
import java.util.List;

/**
 * Dwarven 矮人族
 * <p>
 * DwarvenGoldmineFacade provides a single interface through which users can operate the subsystems.
 *
 * <p>This makes the goldmine easier to operate and
 * cuts the dependencies from the goldmine user to the subsystems.
 * 
 * “门面模式”不大有体会。平时用到“门面模式”的机会太少了
 * 
 */
public class DwarvenGoldmineFacade {

    private final List<DwarvenMineWorker> workers;

    /**
     * Constructor.
     */
    public DwarvenGoldmineFacade() {
        workers = List.of(
                new DwarvenGoldDigger(),
                new DwarvenCartOperator(),
                new DwarvenTunnelDigger());
    }

    /**
     * 又是美好的一天啊
     * <p>
     * 所有人，去矿上
     */
    public void startNewDay() {
        makeActions(workers, DwarvenMineWorker.Action.WAKE_UP, DwarvenMineWorker.Action.GO_TO_MINE);
    }

    /**
     * 所有人，都要努力干活哦
     */
    public void digOutGold() {
        makeActions(workers, DwarvenMineWorker.Action.WORK);
    }

    /**
     * 好了，要下班咯
     *  
     */
    public void endDay() {
        makeActions(workers, DwarvenMineWorker.Action.GO_HOME, DwarvenMineWorker.Action.GO_TO_SLEEP);
    }

    private static void makeActions(Collection<DwarvenMineWorker> workers, DwarvenMineWorker.Action... actions) {
        workers.forEach(worker -> worker.action(actions));
    }
}
