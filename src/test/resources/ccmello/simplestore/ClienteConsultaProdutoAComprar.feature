# language: pt

  # Historia de Usuario:
  # Como um Cliente a procura de um produto,
  # Eu gostaria de saber se o produto está a venda,
  # De modo que Eu possa ser encorajado a comprá-lo.

  # Criterios de Aceite:
  # 1. Procura por um produto por categoria
  # 2. Recebe um aviso ao procurar categoria indisponivel


Funcionalidade: Como Cliente Eu gostaria de consultar produto para comprar
  Fundo:
    Dada a jornada iniciada pelo cliente

  Delineacao do Cenario: Procura por um produto por categoria
    Quando o cliente procurar por "<categoria>"
    Entao uma lista de produtos deve aparecer com produtos pertencentes a "<categoria>"
    E cada produto mostrado aparecera com "<nome>", "<quantidade>" e "<disponivelAVenda>"

    Exemplos:
    | categoria  | nome                   | quantidade | disponivelAVenda |
    | Utensilios | Kit 12 Facas           | 3          | Sim              |
    | Utensilios | Colher de Silicone     | 12         | Sim              |
    | Utensilios | Ralador 4 faces Inox   | 0          | Nao              |

  Delineacao do Cenario: Recebe um aviso ao procurar categoria indisponivel
    Quando o cliente procurar por "<categoria>" indisponivel
    Entao mostre a "<mensagem>" que indique a indisponibilidade da categoria "<categoria>"
    Exemplos:
    | categoria    | mensagem                                |
    | Mesa e banho | Desculpe, a categoria esta indisponivel |
