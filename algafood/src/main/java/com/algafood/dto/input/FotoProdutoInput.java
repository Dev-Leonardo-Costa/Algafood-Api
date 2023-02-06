package com.algafood.dto.input;

import com.algafood.core.validation.FileContentType;
import com.algafood.core.validation.FileSize;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class FotoProdutoInput {

    @NotNull
    @FileSize(max = "20KB")
    @FileContentType(allowed = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    private MultipartFile arquivo;

    @NotBlank
    private String descricao;

}
