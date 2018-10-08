package tech.mutator.documentation.watcher

import tech.mutator.documentation.watcher.cli.{CLIOptions, DocumentationWatcherCLI}
import better.files._

object DocumentationWatcher
	extends DocumentationWatcherCLI
{
	def main(arguments: Array[String]): Unit = {
		cliOptionsParser.parse(arguments, CLIOptions()) match {
			case Some(cliOptions) =>
				val watcher = new FileMonitor(new File(cliOptions.watchingDirectory.toPath()), recursive = true) {
					override def onCreate(file: File, count: Int) = println(s"$file got created")
					override def onModify(file: File, count: Int) = println(s"$file got modified $count times")
					override def onDelete(file: File, count: Int) = println(s"$file got deleted")
				}
			case None =>
		}
	}
}
