package infrastructure.institution.model.command

data class PdfInstitutionCommand(
    val type: PdfInstitutionType
) {
    constructor(type: String) : this(PdfInstitutionType.valueOf(type.uppercase()))
}

enum class PdfInstitutionType {
    LIST;
}
