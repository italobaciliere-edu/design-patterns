<h1>FACTORY METHOD</h1>

<span style="color: red">Creational</span>

<h2>Intenção</h2>

Criar um superclasse que consegue retornar instancias de subclasses.

<h2>Motivação</h2>

Aos poucos a sua implementação irá precisar de sub-classes diferentes.

<h2>Vantagens</h2>

Garante o princípio de aberto/fechado, onde se torna possível inserir novos tipos de
subclasses, sem quebrar o funcionamento de um código funcional.

Evita o forte acoplamento entre o criador 
e os produtos concretos.

<h2>Desvantagens</h2>

A grande quantidade de ifs que você terá em seu código.
E a grande quantidade de subclasses que você terá em seu código.




## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
