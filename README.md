# alura-solid
>Status: Concluído

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

### Aula 04 - Herança indesejada

De acordo com o 3º princípio do SOLID, chamado princípio de Liskov (Esse nome veio da engenheira de software Barbara Liskov) precisamos ter muito cuidado ao utilizarmos da herança porque por mais que algumas coisas sejam parecidas não necessariamente elas são a mesma coisa e no código seus atributos e métodos podem não fazer sentido. Uma forma prática de manter esse princípio é observar se a classe filha continuará tendo o **mesmo** comportamento da classe mãe ao utilizarmos os métodos da classe mãe, se percebermos que a classe filha vai alterar algum comportamento que veio da classe mãe então não devemos usar herança mas talvez sim uma composição.

*"Se q(x) é uma propriedade demonstrável dos objetos x de tipo T, então q(y) deve ser verdadeiro para objetos y de tipo S, ou S é um subtipo de T."*

-- Barbara Liskov

### Aula 05 - Trabalhando com abstrações

Nesse projeto, como consequência da aplicação do Open Closed Principle nós também aplicamos o 5º princípio do SOLID (I - Dependency Inversion Principle). Esse princípio diz que uma implamentação pode depender de uma abstração como uma interface ou classe abstrata mas a abstração não deve depender da implementação.

*"Abstrações não devem depender de implementações. Implementações devem depender de abstrações."

-- Robert (Uncle Bob) Martin

O 4º princípio do SOLID diz a respeito de quando temos uma interface com muitos métodos, pode ocorrer de implementarmos essa interface em uma classe quen não vai utilizar todos os métodos da interface e isso significa que essa implementação está errada porque a classe está sendo forçada a tratar um método que não vai utilizar. A solução para esse tipo de problema é dividir em duas interfaces e nas classes que for necessário, implantar as duas interfaces. Podemos ainda melhorar o reaproveitamento fazendo uma interface herdar da outra.

*"Uma classe não deveria ser forçada a depender de métodos qeu não utilizará."*

-- Robert (Uncle Bob) Martin

## Resumo dos 5 princípios do SOLID
**S**ingle Responsability Principle: Uma classe deve ter uma única resposabilidade;

**O**pen Closed Principle: A classe deve estar aberta a extensão mas fechada para modificação;

**L**iskov Principle: Não deve utilizar herança quando os métodos e atributes não demonstram fazer sentido;

**I**nterface Segregation Principle: Uma classe não deve ser forçada a implantar um método que não será utilizado;

**D**ependency Inversion Principle: Uma implantação deve depender de uma interface mas uma interface jamais deve depender de uma implantação.
