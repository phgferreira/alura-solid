# alura-solid
>Status: Em Desenvolvimento

Link do curso: [SOLID com Java: princípios da programação orientada a objetos](https://www.alura.com.br/curso-online-solid-orientacao-objetos-java)

### Aula 01 - Princípios da orientação a objetos
[Notion Page](https://little-riddle-c13.notion.site/SOLID-com-Java-Princ-pios-da-programa-o-orientada-a-objetos-7391119d13814b238d3cee336b665ccf)

### Aula 02 - Melhornado a coesão

Ao separarmos o método de reajuste salário em uma classe de serviço não só melhoramos a coesão como também aplicamos o primeiro princípio do SOLID (Single of Responsability). Esse princípio diz que uma classe ou método deve atender a um único objetivo.

*“Uma classe deveria ter apenas um único motivo para mudar”*

-- Robert (Uncle Bob) Martin

### Aula 03 - Reduzindo o acoplamento

Na classe reajuste de salário recebemos uma nova regra de validação e, assim sendo, pudemos melhorar ainda mais essa classe. Dividimos cada regra de validação em uma nova classe e unimos todas elas por uma interface em comum, um contrato que especifica um único método que todos devem ter em comum (validar(funcionario, aumento)). Dessa forma nós pudemos tornar a classe ReajusteService expansível sem precisar mexer nela, apenas criando uma nova classe com uma nova regra e adicionando a lista de validações. Dessa fizemos com que o código atenda ao 2º princípio do SOLID (O - Open Closed Principle) que significa que o código deve estar aberto para extensão mas fechado para modificação.

*"Entidades de software (classes, módulos, funções, etc.) devem estar abertas para extensão, porém fechadas para modificação"*

-- Bertrand Meyer
