package com.cmc;

public class TestRunnable {

}

/*
 * private WorkLoadService workLoadService;
 * 
 * public List<WorkLoad> queryListsByMap(String sqlCode, Map<String, Object>
 * parameters) throws Exception { List<WorkLoad> workLoads=new
 * ArrayList<WorkLoad>(); long startTime = System.currentTimeMillis();
 * List<String> dates =
 * DateUtil.getCurrentInYear(parameters.get("startDate").toString(), 12); if
 * (dates != null && dates.size() > 0) { int len = dates.size(); // 创建线程的个数 int
 * count = len % 2 == 0 ? len / 2: (len / 2) + 1; // 创建线程池数量 ExecutorService
 * pool = Executors.newFixedThreadPool(count); List<Callable<List<WorkLoad>>>
 * tasks = new ArrayList<Callable<List<WorkLoad>>>(); for (int i = 0; i < count;
 * i++) { // 每个线程负责插入数据的开始位置 int start = i * 2; // 每个线程负责插入数据的结束位置 int end = i
 * == count - 1 ? i * 2 + (len - i * 2) : i* 2+ 2; Map<String, Object>
 * parametersClone = new HashMap<String, Object>();
 * parametersClone.putAll(parameters); // 线程返回值 Callable<List<WorkLoad>> task =
 * new QueryThread(parametersClone, sqlCode, dates, start, end,workLoadService);
 * tasks.add(task); } // 执行线程 List<Future<List<WorkLoad>>> futures =
 * pool.invokeAll(tasks); // 处理线程返回结果 if (futures != null && futures.size() > 0)
 * { for (Future<List<WorkLoad>> future : futures) {
 * workLoads.addAll(future.get()); } } // 关闭线程池 pool.shutdown(); } long endTime
 * = System.currentTimeMillis(); logger.info("多个情况报表查询总共花了:" + (endTime -
 * startTime) / 1000 + "秒时间!"); return workLoads; }
 */
