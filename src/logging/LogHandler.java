package logging;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

import frame.DrawingFrame;

public class LogHandler extends Handler {
	private DrawingFrame frame;
		public LogHandler(DrawingFrame frame)
		{
			this.frame=frame;
		}
		  @Override
		  public void publish(LogRecord record) {
		      StringBuilder sb = new StringBuilder();
		      String[] name=record.getSourceClassName().split("\\.");
		      sb.append(name[name.length-1])
		        .append("_")
		        .append(record.getSourceMethodName())
		        .append("_")
		        .append(record.getMessage());
		      System.out.println(sb.toString());
		      String text=frame.getLogView().getLogPane().getText();
		      frame.getLogView().getLogPane().setText(text+sb.toString()+"\n");
		  }

		  @Override
		  public void flush() {
		  }

		  @Override
		  public void close() throws SecurityException {
		  }


}
