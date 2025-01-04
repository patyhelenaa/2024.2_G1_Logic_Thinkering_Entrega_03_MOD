package com.logic_thinkering;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BookGui extends LightweightGuiDescription {

    private final BookGuide book;

    private final WButton previousButton;
    private final WButton nextButton;

    private final List<WLabel> textLabels = new ArrayList<>();

    private final List<WSprite> icons = new ArrayList<>();

    public BookGui(BookGuide book) {
        this.book = book;


        // Painel principal
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setInsets(Insets.NONE);
        root.setSize(250, 250);
        root.setInsets(Insets.ROOT_PANEL);

        WSprite background = new WSprite(Identifier.of("logic_thinkering", "textures/client/background.png"));
        root.add(background, 0, 0, 14, 13);  //

        // Título
        WLabel titleLabel = new WLabel(Text.literal(book.getCurrentPage().getTitle()));
        root.add(titleLabel, 1, 1);

        // Texto
        addPageText(root, book.getCurrentPage().getText(), 40, 2 );

        // imagem
        updatePageImage(root, book.getCurrentPage().getImagePath());

        // Botão Anterior
        previousButton = new WButton(Text.literal("Anterior"));
        previousButton.setEnabled(book.hasPreviousPage());
        previousButton.setOnClick(() -> {
            book.previousPage();
            updatePage(root, titleLabel);
        });
        root.add(previousButton, 1, 11,4,1);

        // Botão Próximo
        nextButton = new WButton(Text.literal("Próximo"));
        nextButton.setEnabled(book.hasNextPage());
        nextButton.setOnClick(() -> {
            book.nextPage();
            updatePage(root, titleLabel);
        });
        root.add(nextButton, 8, 11,4,1);

        root.validate(this);
    }

    /* Atualiza a imagem da página */
    private void updatePageImage(WGridPanel root, String imagePath) {
        // Remover a anterior
        for (WSprite icon : icons) {
            root.remove(icon);
        }
        icons.clear();

        // Adicionar a nova
        WSprite newIcon = new WSprite(Identifier.of("logic_thinkering", imagePath));
        icons.add(newIcon);
        root.add(newIcon, 1, 3,12, 6);
    }

    /* Quebrar o texto */
    private void addPageText(WGridPanel root, String text, int maxLineLength, int startY) {
        // Limpar os labels anteriores
        for (WLabel label : textLabels) {
            root.remove(label);
        }
        textLabels.clear();

        List<String> wrappedLines = wrapText(text, maxLineLength);

        int y = startY;
        for (String line : wrappedLines) {
            WLabel lineLabel = new WLabel(Text.literal(line));
            textLabels.add(lineLabel);
            root.add(lineLabel, 1, y++);
        }
    }

    // Quebra o texto em várias linhas
    private List<String> wrapText(String text, int maxLineLength) {
        List<String> lines = new ArrayList<>();
        StringBuilder currentLine = new StringBuilder();

        for (String word : text.split(" ")) {
            if (currentLine.length() + word.length() > maxLineLength) {
                lines.add(currentLine.toString().trim());
                currentLine = new StringBuilder();
            }
            currentLine.append(word).append(" ");
        }

        if (!currentLine.isEmpty()) {
            lines.add(currentLine.toString().trim());
        }

        return lines;
    }

    /* Atualiza a página */
    private void updatePage(WGridPanel root, WLabel titleLabel) {
        BookPage currentPage = book.getCurrentPage();

        titleLabel.setText(Text.literal(currentPage.getTitle()));

        addPageText(root, currentPage.getText(), 40, 2);

        updatePageImage(root, currentPage.getImagePath());

        previousButton.setEnabled(book.hasPreviousPage());
        nextButton.setEnabled(book.hasNextPage());
    }
}