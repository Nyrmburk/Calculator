package ui;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.text.DecimalFormat;
import java.util.Stack;

import javax.swing.table.DefaultTableModel;

import calc.Function;
import calc.Operator;
import calc.Postfix;
import calc.VariableSet;
import calc.Function.Functions;
import calc.Operator.Operators;

import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.StringSelection;

/**
 *
 * @author Christopher Dombroski
 */

@SuppressWarnings("serial")
public class CalcGui extends javax.swing.JFrame implements ClipboardOwner {

	Stack<String> inputs;

	/**
	 * Creates new form CalcGui
	 */
	public CalcGui() {

		initComponents();
		inputs = new Stack<String>();
	}

	/**
	 * initialize the gui components.
	 */
	@SuppressWarnings({ "unchecked" })
	private void initComponents() {

		jlblMessages = new javax.swing.JLabel();
		jtxtMath = new javax.swing.JTextField();
		jpnlControl = new javax.swing.JPanel();
		jbtnClear = new javax.swing.JButton();
		jbtnClearEntry = new javax.swing.JButton();
		jscrlVariables = new javax.swing.JScrollPane();
		jtblVariables = new javax.swing.JTable();
		jbtnAddVariable = new javax.swing.JButton();
		jbtnRemoveVariable = new javax.swing.JButton();
		jpnlOperatorsAndValues = new javax.swing.JPanel();
		jbtn7 = new javax.swing.JButton();
		jbtn8 = new javax.swing.JButton();
		jbtn9 = new javax.swing.JButton();
		jbtnAdd = new javax.swing.JButton();
		jbtnMultiply = new javax.swing.JButton();
		jbtn4 = new javax.swing.JButton();
		jbtn5 = new javax.swing.JButton();
		jbtn6 = new javax.swing.JButton();
		jbtnSubtract = new javax.swing.JButton();
		jbtnDivide = new javax.swing.JButton();
		jbtn1 = new javax.swing.JButton();
		jbtn2 = new javax.swing.JButton();
		jbtn3 = new javax.swing.JButton();
		jbtnPower = new javax.swing.JButton();
		jbtnRemainder = new javax.swing.JButton();
		jbtnNegate = new javax.swing.JButton();
		jbtn0 = new javax.swing.JButton();
		jbtnDecimal = new javax.swing.JButton();
		jbtnInverse = new javax.swing.JButton();
		jbtnEnter = new javax.swing.JButton();
		jpnlFunctions = new javax.swing.JPanel();
		jbtnSin = new javax.swing.JButton();
		jbtnCos = new javax.swing.JButton();
		jbtnTan = new javax.swing.JButton();
		jbtnFloor = new javax.swing.JButton();
		jbtnCeil = new javax.swing.JButton();
		jbtnSinh = new javax.swing.JButton();
		jbtnCosh = new javax.swing.JButton();
		jbtnTanh = new javax.swing.JButton();
		jbtnCbrt = new javax.swing.JButton();
		jbtnSqrt = new javax.swing.JButton();
		jbtnAsin = new javax.swing.JButton();
		jbtnAcos = new javax.swing.JButton();
		jbtnAtan = new javax.swing.JButton();
		jbtnRadical = new javax.swing.JButton();
		jbtnMod = new javax.swing.JButton();
		jbtnAtan2 = new javax.swing.JButton();
		jbtnLeftParathesis = new javax.swing.JButton();
		jbtnRightParenthesis = new javax.swing.JButton();
		jbtnSpace = new javax.swing.JButton();
		jbtnComma = new javax.swing.JButton();
		jbtnInsert = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jlblMessages.setHorizontalAlignment(javax.swing.JLabel.TRAILING);
		jlblMessages.setText(" ");

		jtxtMath.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
		jtxtMath.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				jtxtMathKeyReleasePerformed(evt);
			}
		});
		jtxtMath.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnEnterActionPerformed(evt);
			}
		});

		jpnlControl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		jpnlControl.setLayout(new java.awt.GridLayout(2, 1));

		jbtnClear.setText("C");
		jbtnClear.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnClearActionPerformed(evt);
			}
		});
		jpnlControl.add(jbtnClear);

		jbtnClearEntry.setText("CE");
		jbtnClearEntry.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnClearEntryActionPerformed(evt);
			}
		});
		jpnlControl.add(jbtnClearEntry);

		jtblVariables.setModel(
				new javax.swing.table.DefaultTableModel(new Object[6][2], new String[] { "Variable", "Value" }) {
					@SuppressWarnings("rawtypes")
					Class[] types = new Class[] { java.lang.String.class, java.lang.Double.class };

					@SuppressWarnings("rawtypes")
					public Class getColumnClass(int columnIndex) {
						return types[columnIndex];
					}
				});
		jtblVariables.getModel().setValueAt("pi", 0, 0);
		jtblVariables.getModel().setValueAt(Math.PI, 0, 1);
		jtblVariables.getModel().setValueAt("e", 1, 0);
		jtblVariables.getModel().setValueAt(Math.E, 1, 1);
		jscrlVariables.setViewportView(jtblVariables);

		jbtnAddVariable.setText("Add");
		jbtnAddVariable.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnAddVariableActionPerformed(evt);
			}
		});

		jbtnRemoveVariable.setText("Remove");
		jbtnRemoveVariable.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnRemoveVariableActionPerformed(evt);
			}
		});

		jpnlOperatorsAndValues.setLayout(new java.awt.GridLayout(4, 5));

		jbtn7.setText("7");
		jbtn7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtn7ActionPerformed(evt);
			}
		});
		jpnlOperatorsAndValues.add(jbtn7);

		jbtn8.setText("8");
		jbtn8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtn8ActionPerformed(evt);
			}
		});
		jpnlOperatorsAndValues.add(jbtn8);

		jbtn9.setText("9");
		jbtn9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtn9ActionPerformed(evt);
			}
		});
		jpnlOperatorsAndValues.add(jbtn9);

		jbtnAdd.setText("+");
		jbtnAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnAddActionPerformed(evt);
			}
		});
		jpnlOperatorsAndValues.add(jbtnAdd);

		jbtnMultiply.setText("*");
		jbtnMultiply.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnMultiplyActionPerformed(evt);
			}
		});
		jpnlOperatorsAndValues.add(jbtnMultiply);

		jbtn4.setText("4");
		jbtn4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtn4ActionPerformed(evt);
			}
		});
		jpnlOperatorsAndValues.add(jbtn4);

		jbtn5.setText("5");
		jbtn5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtn5ActionPerformed(evt);
			}
		});
		jpnlOperatorsAndValues.add(jbtn5);

		jbtn6.setText("6");
		jbtn6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtn6ActionPerformed(evt);
			}
		});
		jpnlOperatorsAndValues.add(jbtn6);

		jbtnSubtract.setText("-");
		jbtnSubtract.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnSubtractActionPerformed(evt);
			}
		});
		jpnlOperatorsAndValues.add(jbtnSubtract);

		jbtnDivide.setText("/");
		jbtnDivide.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnDivideActionPerformed(evt);
			}
		});
		jpnlOperatorsAndValues.add(jbtnDivide);

		jbtn1.setText("1");
		jbtn1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtn1ActionPerformed(evt);
			}
		});
		jpnlOperatorsAndValues.add(jbtn1);

		jbtn2.setText("2");
		jbtn2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtn2ActionPerformed(evt);
			}
		});
		jpnlOperatorsAndValues.add(jbtn2);

		jbtn3.setText("3");
		jbtn3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtn3ActionPerformed(evt);
			}
		});
		jpnlOperatorsAndValues.add(jbtn3);

		jbtnPower.setText("^");
		jbtnPower.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnPowerActionPerformed(evt);
			}
		});
		jpnlOperatorsAndValues.add(jbtnPower);

		jbtnRemainder.setText("%");
		jbtnRemainder.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnRemainderActionPerformed(evt);
			}
		});
		jpnlOperatorsAndValues.add(jbtnRemainder);

		jbtnNegate.setText("+/-");
		jbtnNegate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnNegateActionPerformed(evt);
			}
		});
		jpnlOperatorsAndValues.add(jbtnNegate);

		jbtn0.setText("0");
		jbtn0.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtn0ActionPerformed(evt);
			}
		});
		jpnlOperatorsAndValues.add(jbtn0);

		jbtnDecimal.setText(".");
		jbtnDecimal.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnDecimalActionPerformed(evt);
			}
		});
		jpnlOperatorsAndValues.add(jbtnDecimal);

		jbtnInverse.setText("1/n");
		jbtnInverse.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnInverseActionPerformed(evt);
			}
		});
		jpnlOperatorsAndValues.add(jbtnInverse);

		jbtnEnter.setText("Enter");
		jbtnEnter.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnEnterActionPerformed(evt);
			}
		});
		jpnlOperatorsAndValues.add(jbtnEnter);

		jpnlFunctions.setLayout(new java.awt.GridLayout(4, 4));

		jbtnSin.setText("sin");
		jbtnSin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnSinActionPerformed(evt);
			}
		});
		jpnlFunctions.add(jbtnSin);

		jbtnCos.setText("cos");
		jbtnCos.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnCosActionPerformed(evt);
			}
		});
		jpnlFunctions.add(jbtnCos);

		jbtnTan.setText("tan");
		jbtnTan.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnTanActionPerformed(evt);
			}
		});
		jpnlFunctions.add(jbtnTan);

		jbtnFloor.setText("floor");
		jbtnFloor.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnFloorActionPerformed(evt);
			}
		});
		jpnlFunctions.add(jbtnFloor);

		jbtnCeil.setText("ceil");
		jbtnCeil.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnCeilActionPerformed(evt);
			}
		});
		jpnlFunctions.add(jbtnCeil);

		jbtnSinh.setText("sinh");
		jbtnSinh.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnSinhActionPerformed(evt);
			}
		});
		jpnlFunctions.add(jbtnSinh);

		jbtnCosh.setText("cosh");
		jbtnCosh.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnCoshActionPerformed(evt);
			}
		});
		jpnlFunctions.add(jbtnCosh);

		jbtnTanh.setText("tanh");
		jbtnTanh.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnTanhActionPerformed(evt);
			}
		});
		jpnlFunctions.add(jbtnTanh);

		jbtnCbrt.setText("cbrt");
		jbtnCbrt.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnCbrtActionPerformed(evt);
			}
		});
		jpnlFunctions.add(jbtnCbrt);

		jbtnSqrt.setText("sqrt");
		jbtnSqrt.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnSqrtActionPerformed(evt);
			}
		});
		jpnlFunctions.add(jbtnSqrt);

		jbtnAsin.setText("asin");
		jbtnAsin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnAsinActionPerformed(evt);
			}
		});
		jpnlFunctions.add(jbtnAsin);

		jbtnAcos.setText("acos");
		jbtnAcos.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnAcosActionPerformed(evt);
			}
		});
		jpnlFunctions.add(jbtnAcos);

		jbtnAtan.setText("atan");
		jbtnAtan.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnAtanActionPerformed(evt);
			}
		});
		jpnlFunctions.add(jbtnAtan);

		jbtnAtan2.setText("atan2");
		jbtnAtan2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnAtan2ActionPerformed(evt);
			}
		});
		jpnlFunctions.add(jbtnAtan2);

		jbtnRadical.setText("root");
		jbtnRadical.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnRadicalActionPerformed(evt);
			}
		});
		jpnlFunctions.add(jbtnRadical);

		jbtnMod.setText("mod");
		jbtnMod.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnModActionPerformed(evt);
			}
		});
		jpnlFunctions.add(jbtnMod);

		jbtnLeftParathesis.setText("(");
		jbtnLeftParathesis.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnLeftParathesisActionPerformed(evt);
			}
		});
		jpnlFunctions.add(jbtnLeftParathesis);

		jbtnRightParenthesis.setText(")");
		jbtnRightParenthesis.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnRightParenthesisActionPerformed(evt);
			}
		});
		jpnlFunctions.add(jbtnRightParenthesis);

		jbtnComma.setText(",");
		jbtnComma.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnCommaActionPerformed(evt);
			}
		});
		jpnlFunctions.add(jbtnComma);

		jbtnSpace.setText("_");
		jbtnSpace.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnSpaceActionPerformed(evt);
			}
		});
		jpnlFunctions.add(jbtnSpace);

		jbtnInsert.setText("Insert");
		jbtnInsert.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnInsertActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup()
										.addComponent(jbtnAddVariable, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jbtnRemoveVariable, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(jbtnInsert, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jscrlVariables, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addGroup(layout.createSequentialGroup()
								.addComponent(jpnlControl, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jpnlFunctions, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jpnlOperatorsAndValues, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addComponent(jtxtMath).addComponent(jlblMessages, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(jtxtMath, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jlblMessages).addGap(12, 12, 12)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup()
												.addComponent(jpnlFunctions, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jpnlOperatorsAndValues,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(jpnlControl, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(0, 0, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
								.addComponent(jscrlVariables, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
										Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jbtnInsert)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jbtnRemoveVariable).addComponent(jbtnAddVariable))))
				.addContainerGap()));

		setTitle("Calculator");
		this.setResizable(false);
		this.pack();
		this.setAlwaysOnTop(true);

		jtxtMath.requestFocusInWindow();
	}

	/**
	 * update the input stack
	 */
	private void jtxtMathKeyReleasePerformed(java.awt.event.KeyEvent evt) {

		if (evt.getKeyChar() != 10 && evt.getKeyChar() != 13)
			inputs.push(jtxtMath.getText());
	}

	/**
	 * pass the string to be parsed and calculated
	 */
	private void jbtnEnterActionPerformed(java.awt.event.ActionEvent evt) {

		jlblMessages.setForeground(Color.BLACK);
		VariableSet set = setVariables();
		Postfix parser = new Postfix(set);

		double answer = 0.0;
		try {
			answer = parser.parse(jtxtMath.getText());
			DecimalFormat df = new DecimalFormat("0.################");

			jlblMessages.setText("= " + df.format(answer));

			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection stringSelection = new StringSelection(df.format(answer));
			clipboard.setContents(stringSelection, this);
		} catch (NumberFormatException e) {

			jlblMessages.setForeground(Color.RED);
			jlblMessages.setText(e.getMessage());
		}

	}

	private void jbtnAddVariableActionPerformed(java.awt.event.ActionEvent evt) {
		((DefaultTableModel) jtblVariables.getModel()).addRow(new Object[0]);
	}

	private void jbtnClearActionPerformed(java.awt.event.ActionEvent evt) {
		clear();
	}

	/**
	 * update the input stack by popping off the latest copy
	 */
	private void jbtnClearEntryActionPerformed(java.awt.event.ActionEvent evt) {

		if (!inputs.isEmpty()) {
			inputs.pop();

			if (!inputs.isEmpty()) {
				jtxtMath.setText(inputs.peek());
			} else {
				jtxtMath.setText("");
			}
		}
	}

	/**
	 * insert the currectly selected variable to the text box
	 */
	private void jbtnInsertActionPerformed(java.awt.event.ActionEvent evt) {

		DefaultTableModel model = ((DefaultTableModel) jtblVariables.getModel());
		int selectedRow = jtblVariables.getSelectedRow();
		if (selectedRow >= 0) {
			String variableName = (String) model.getValueAt(selectedRow, 0);
			if (variableName != null && !variableName.isEmpty())
				append(variableName);
		}
	}

	/**
	 * remove the currently selected variable or the last row if none selected
	 */
	private void jbtnRemoveVariableActionPerformed(java.awt.event.ActionEvent evt) {
		DefaultTableModel model = ((DefaultTableModel) jtblVariables.getModel());
		int selectedRow = jtblVariables.getSelectedRow();
		if (selectedRow >= 0) {

			model.removeRow(selectedRow);
		} else if (model.getRowCount() > 0) {

			model.removeRow(model.getRowCount() - 1);
		}
	}

	private void jbtn0ActionPerformed(java.awt.event.ActionEvent evt) {
		append("0");
	}

	private void jbtn1ActionPerformed(java.awt.event.ActionEvent evt) {
		append("1");
	}

	private void jbtn2ActionPerformed(java.awt.event.ActionEvent evt) {
		append("2");
	}

	private void jbtn3ActionPerformed(java.awt.event.ActionEvent evt) {
		append("3");
	}

	private void jbtn4ActionPerformed(java.awt.event.ActionEvent evt) {
		append("4");
	}

	private void jbtn5ActionPerformed(java.awt.event.ActionEvent evt) {
		append("5");
	}

	private void jbtn6ActionPerformed(java.awt.event.ActionEvent evt) {
		append("6");
	}

	private void jbtn7ActionPerformed(java.awt.event.ActionEvent evt) {
		append("7");
	}

	private void jbtn8ActionPerformed(java.awt.event.ActionEvent evt) {
		append("8");
	}

	private void jbtn9ActionPerformed(java.awt.event.ActionEvent evt) {
		append("9");
	}

	private void jbtnDecimalActionPerformed(java.awt.event.ActionEvent evt) {
		append(".");
	}

	private void jbtnAddActionPerformed(java.awt.event.ActionEvent evt) {
		append(Operator.getName(Operators.ADD));
	}

	private void jbtnSubtractActionPerformed(java.awt.event.ActionEvent evt) {
		append(Operator.getName(Operators.SUBTRACT));
	}

	private void jbtnMultiplyActionPerformed(java.awt.event.ActionEvent evt) {
		append(Operator.getName(Operators.MULTIPLY));
	}

	private void jbtnDivideActionPerformed(java.awt.event.ActionEvent evt) {
		append(Operator.getName(Operators.DIVIDE));
	}

	private void jbtnPowerActionPerformed(java.awt.event.ActionEvent evt) {
		append(Operator.getName(Operators.POWER));
	}

	private void jbtnRemainderActionPerformed(java.awt.event.ActionEvent evt) {
		append(Operator.getName(Operators.REMAINDER));
	}

	private void jbtnInverseActionPerformed(java.awt.event.ActionEvent evt) {
		append(Function.getName(Functions.INVERSE) + '(');
	}

	private void jbtnNegateActionPerformed(java.awt.event.ActionEvent evt) {
		append(Function.getName(Functions.NEGATE) + '(');
	}

	private void jbtnSinActionPerformed(java.awt.event.ActionEvent evt) {
		append(Function.getName(Functions.SIN) + '(');
	}

	private void jbtnCosActionPerformed(java.awt.event.ActionEvent evt) {
		append(Function.getName(Functions.COS) + '(');
	}

	private void jbtnTanActionPerformed(java.awt.event.ActionEvent evt) {
		append(Function.getName(Functions.TAN) + '(');
	}

	private void jbtnFloorActionPerformed(java.awt.event.ActionEvent evt) {
		append(Function.getName(Functions.FLOOR) + '(');
	}

	private void jbtnCeilActionPerformed(java.awt.event.ActionEvent evt) {
		append(Function.getName(Functions.CEIL) + '(');
	}

	private void jbtnSqrtActionPerformed(java.awt.event.ActionEvent evt) {
		append(Function.getName(Functions.SQRT) + '(');
	}

	private void jbtnModActionPerformed(java.awt.event.ActionEvent evt) {
		append(Function.getName(Functions.MODULO) + '(');
	}

	private void jbtnCbrtActionPerformed(java.awt.event.ActionEvent evt) {
		append(Function.getName(Functions.CBRT) + '(');
	}

	private void jbtnRadicalActionPerformed(java.awt.event.ActionEvent evt) {
		append(Function.getName(Functions.ROOT) + '(');
	}

	private void jbtnAsinActionPerformed(java.awt.event.ActionEvent evt) {
		append(Function.getName(Functions.ASIN) + '(');
	}

	private void jbtnAcosActionPerformed(java.awt.event.ActionEvent evt) {
		append(Function.getName(Functions.ACOS) + '(');
	}

	private void jbtnAtanActionPerformed(java.awt.event.ActionEvent evt) {
		append(Function.getName(Functions.ATAN) + '(');
	}

	private void jbtnAtan2ActionPerformed(java.awt.event.ActionEvent evt) {
		append(Function.getName(Functions.ATAN2) + '(');
	}

	private void jbtnSinhActionPerformed(java.awt.event.ActionEvent evt) {
		append(Function.getName(Functions.SINH) + '(');
	}

	private void jbtnCoshActionPerformed(java.awt.event.ActionEvent evt) {
		append(Function.getName(Functions.COSH) + '(');
	}

	private void jbtnTanhActionPerformed(java.awt.event.ActionEvent evt) {
		append(Function.getName(Functions.TANH) + '(');
	}

	private void jbtnLeftParathesisActionPerformed(java.awt.event.ActionEvent evt) {
		append("(");
	}

	private void jbtnRightParenthesisActionPerformed(java.awt.event.ActionEvent evt) {
		append(")");
	}

	private void jbtnSpaceActionPerformed(java.awt.event.ActionEvent evt) {

		append(" ");
	}

	private void jbtnCommaActionPerformed(java.awt.event.ActionEvent evt) {

		append(",");
	}

	/**
	 * append a String to the text box
	 * 
	 * @param toAppend
	 */
	private void append(String toAppend) {

		String total = jtxtMath.getText() + toAppend;
		inputs.push(total);
		jtxtMath.setText(total);
	}

	/**
	 * clear the text box, input stack, and messages
	 */
	private void clear() {

		inputs.clear();
		jtxtMath.setText("");
		jlblMessages.setText(" ");
	}

	/**
	 * put all the data in the variable table to a VariableSet
	 * 
	 * @return a VariableSet containing all the variables in the variable table
	 */
	private VariableSet setVariables() {

		VariableSet set = new VariableSet();
		DefaultTableModel model = ((DefaultTableModel) jtblVariables.getModel());
		for (int i = 0; i < model.getRowCount(); i++) {

			String name = (String) model.getValueAt(i, 0);
			Double value = (Double) model.getValueAt(i, 1);
			if (value == null)
				value = 0.0;
			if (name != null && !name.isEmpty()) {

				set.register(name, value);
			}
		}

		return set;
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {

		String lookAndFeel = "Nimbus";

		String os = System.getProperty("os.name");

		if (os.toLowerCase().startsWith("win"))
			lookAndFeel = "Windows";

		/* Set the Nimbus look and feel */
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if (lookAndFeel.equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(CalcGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(CalcGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(CalcGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(CalcGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CalcGui().setVisible(true);
			}
		});
	}

	private javax.swing.JButton jbtnClearEntry;
	private javax.swing.JButton jbtnInverse;
	private javax.swing.JButton jbtn0;
	private javax.swing.JButton jbtn1;
	private javax.swing.JButton jbtn2;
	private javax.swing.JButton jbtn3;
	private javax.swing.JButton jbtn4;
	private javax.swing.JButton jbtn5;
	private javax.swing.JButton jbtn6;
	private javax.swing.JButton jbtn7;
	private javax.swing.JButton jbtn8;
	private javax.swing.JButton jbtn9;
	private javax.swing.JButton jbtnAcos;
	private javax.swing.JButton jbtnAdd;
	private javax.swing.JButton jbtnAddVariable;
	private javax.swing.JButton jbtnAsin;
	private javax.swing.JButton jbtnAtan;
	private javax.swing.JButton jbtnAtan2;
	private javax.swing.JButton jbtnCbrt;
	private javax.swing.JButton jbtnCeil;
	private javax.swing.JButton jbtnClear;
	private javax.swing.JButton jbtnCos;
	private javax.swing.JButton jbtnCosh;
	private javax.swing.JButton jbtnDecimal;
	private javax.swing.JButton jbtnDivide;
	private javax.swing.JButton jbtnEnter;
	private javax.swing.JButton jbtnFloor;
	private javax.swing.JButton jbtnInsert;
	private javax.swing.JButton jbtnNegate;
	private javax.swing.JButton jbtnLeftParathesis;
	private javax.swing.JButton jbtnMod;
	private javax.swing.JButton jbtnPower;
	private javax.swing.JButton jbtnRadical;
	private javax.swing.JButton jbtnRemainder;
	private javax.swing.JButton jbtnRemoveVariable;
	private javax.swing.JButton jbtnRightParenthesis;
	private javax.swing.JButton jbtnSin;
	private javax.swing.JButton jbtnSinh;
	private javax.swing.JButton jbtnSqrt;
	private javax.swing.JButton jbtnSubtract;
	private javax.swing.JButton jbtnTan;
	private javax.swing.JButton jbtnTanh;
	private javax.swing.JButton jbtnMultiply;
	private javax.swing.JButton jbtnSpace;
	private javax.swing.JButton jbtnComma;
	private javax.swing.JPanel jpnlControl;
	private javax.swing.JPanel jpnlFunctions;
	private javax.swing.JPanel jpnlOperatorsAndValues;
	private javax.swing.JLabel jlblMessages;
	private javax.swing.JScrollPane jscrlVariables;
	private javax.swing.JTable jtblVariables;
	private javax.swing.JTextField jtxtMath;

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
	}
}
