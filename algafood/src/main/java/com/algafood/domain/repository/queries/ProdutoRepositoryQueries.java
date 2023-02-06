package com.algafood.domain.repository.queries;

import com.algafood.domain.model.FotoProduto;

public interface ProdutoRepositoryQueries {

    FotoProduto salvar(FotoProduto foto);

    void delete(FotoProduto foto);

}
