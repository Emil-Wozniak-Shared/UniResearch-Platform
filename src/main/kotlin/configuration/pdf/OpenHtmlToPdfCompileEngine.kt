package configuration.pdf

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder
import java.io.ByteArrayOutputStream

class OpenHtmlToPdfCompileEngine : PdfCompileEngine {
    override fun compile(compileData: CompileData): ByteArray = ByteArrayOutputStream().use { stream ->
        PdfRendererBuilder().run {
            useFastMode()
            withHtmlContent(compileData.html, null)
            toStream(stream)
            run()
        }
        stream
    }.toByteArray()
}