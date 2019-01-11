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

		      System.out.println(record.getMessage());
		      String text=frame.getLogView().getLogPane().getText();
		      frame.getLogView().getLogPane().setText(text+record.getMessage()+"\n");
		  }

		  @Override
		  public void flush() {
		  }

		  @Override
		  public void close() throws SecurityException {
		  }


}
