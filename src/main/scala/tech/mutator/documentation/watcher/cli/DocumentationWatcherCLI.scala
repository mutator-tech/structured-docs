package tech.mutator.documentation.watcher.cli

import scopt._
import java.io.File

case class CLIOptions(
	watchingDirectory: File = new File(".")
)

trait DocumentationWatcherCLI {
	implicit val fileRead: Read[File] = Read.reads { new File(_) }

	val cliOptionsParser = new scopt.OptionParser[CLIOptions]("scopt") {
		head("documentation-watcher 0.0.0")

		opt[File]('w', "watching-directory")
			.required()
			.valueName("<directory>")
    		.text("watching-directory is required documentation watcher property")
	}
}
