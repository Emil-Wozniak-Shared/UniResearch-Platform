package infrastructure.institution.adapter.out.pdf

import configuration.pdf.CompileData
import configuration.pdf.PdfCompileEngine
import domain.institution.InstitutionEntity
import infrastructure.institution.model.event.ListPdfInstitutionEvent
import infrastructure.institution.model.result.PdfInstitutionResult
import infrastructure.institution.port.out.pdf.InstitutionPdfPort
import kotlinx.html.*
import kotlinx.html.stream.createHTML

class InstitutionPdfAdapter(
    private val pdfCompileEngine: PdfCompileEngine
) : InstitutionPdfPort {
    override suspend fun list(event: ListPdfInstitutionEvent): PdfInstitutionResult {
        val template = template(event.institutions)
        val bytes = pdfCompileEngine.compile(CompileData(template))
        return PdfInstitutionResult(
            content = bytes,
            filename = "sample"
        )
    }

    private fun template(institutions: List<InstitutionEntity>): String = createHTML().html {
        head {
            unsafe { +"<meta charset = \"UTF-8\"></meta>" }
            title { +"Raport Instytucji Naukowych" }
            style {
                unsafe {
                    +"""
                    body { font-family: Arial, sans-serif; margin: 20px; line-height: 1.4; }
                    h1 { text-align: center; color: #1A237E; }
                    h2 { color: #1A237E; margin-top: 30px; }
                    table { width: 100%; border-collapse: collapse; margin-top: 10px; }
                    th, td { border: 1px solid #333; padding: 8px; text-align: left; }
                    th { background-color: #e0e0e0; }
                    .sekcja-instytucji { margin-bottom: 40px; }
                    footer { text-align: center; margin-top: 50px; font-size: 0.9em; color: #555; }
                    """.trimIndent()
                }
            }
        }
        body {
            h1 { +"Government Institutions Report" }
            institutions.forEach { institution ->
                div("institution-section") {
                    h2 { +institution.name }

                    table {
                        tr {
                            th { +"Field" }
                            th { +"Value" }
                        }
                        tr {
                            td { +"ID" }
                            td { +institution.id.toString() }
                        }
                        tr {
                            td { +"Type" }
                            td { +institution.type }
                        }
                        tr {
                            td { +"Founded Year" }
                            td { +institution.foundedYear.toString() }
                        }
                        tr {
                            td { +"Location ID" }
                            td { +institution.locationId.toString() }
                        }
                        tr {
                            td { +"University ID" }
                            td { +institution.universityId.toString() }
                        }
                        tr {
                            td { +"Scientific Field ID" }
                            td { +institution.scientificFieldId.toString() }
                        }
                    }
                }
            }

            footer {
                p { +"Report generated on: ${java.time.LocalDate.now()}" }
            }
        }
    }
}