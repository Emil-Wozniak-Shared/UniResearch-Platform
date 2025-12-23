package configuration.pdf

data class CompileData(
    val html: String
)

interface PdfCompileEngine {
    fun compile(compileData: CompileData): ByteArray
}
