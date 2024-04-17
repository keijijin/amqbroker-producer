# amqbroker-publisher

このプロジェクトはAMQBrokerを使用して、指定されたキューに10個のメッセージを送信するPublisherプログラムを提供します。Java言語で書かれています。

## 技術スタック
- AMQBroker
- Java

## 前提条件

プロジェクトを実行する前に、以下の要件を満たしていることを確認してください：
* Javaがインストールされていること
* Mavenがインストールされていること

## セットアップ手順

プロジェクトをローカル環境にセットアップするには、以下の手順に従ってください：

```bash
git clone [プロジェクトのGitリポジトリURL]
cd amqbroker-publisher
mvn clean package
```
これにより、必要な依存関係がインストールされ、プロジェクトがビルドされます。

## 使用方法
アプリケーションを実行するには、次のコマンドを実行します：
```bash
java -jar target/amqbroker-producer-1.0.0-SNAPSHOT-jar-with-dependencies.jar [キュー名]
```
ここで [キュー名] はオプショナルで、指定されない場合は demo キューにメッセージが送信されます。例えば ny.customer.info キューにメッセージを送る場合は、次のようにします：
```bash
java -jar target/amqbroker-producer-1.0.0-SNAPSHOT-jar-with-dependencies.jar ny.customer.info
```